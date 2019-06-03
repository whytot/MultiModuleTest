package com.bill.multi.compiler;

import com.bill.multi.annotation.MultiService;
import com.bill.multi.annotation.MutliComponent;
import com.bill.multi.annotation.MutliInject;
import com.bill.multi.annotation.MutliModule;
import com.google.auto.service.AutoService;
import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import com.squareup.javapoet.TypeVariableName;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import static javax.lang.model.element.ElementKind.CLASS;

/**
 * @author Bill.WangBW
 */
@AutoService(Processor.class)
public class ModuleProcessor extends AbstractProcessor {
    Filer mFiler;
    Types types;
    Elements elementUtils;
    // Module name, maybe its 'app' or others
    String moduleName = null;

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> types = new LinkedHashSet<>();
        types.add(MutliModule.class.getCanonicalName());
        types.add(MutliInject.class.getCanonicalName());
        types.add(MutliComponent.class.getCanonicalName());
        types.add(MultiService.class.getCanonicalName());
        return types;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.RELEASE_8;
    }

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        mFiler = processingEnv.getFiler();
        elementUtils = processingEnv.getElementUtils();
        types = processingEnv.getTypeUtils();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        if (annotations == null || annotations.isEmpty()) {
            return false;
        }
        Set<? extends Element> modulesElements = roundEnv.getElementsAnnotatedWith(MutliModule.class);
        Set<? extends Element> injectElements = roundEnv.getElementsAnnotatedWith(MutliInject.class);
        Set<? extends Element> componentElements = roundEnv.getElementsAnnotatedWith(MutliComponent.class);
        Set<? extends Element> serviceElements = roundEnv.getElementsAnnotatedWith(MultiService.class);
        try {
//            parseModules(modulesElements);
//            parseInject(injectElements);
//            parseComponent(componentElements);
            parseService(serviceElements);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("aaaaa");
            throw new AssertionError(e);
        }
        return true;
    }

    private void parseService(Set<? extends Element> serviceElements) throws IOException, ClassNotFoundException {
        List<FieldSpec> serviceFieldSpecs = new ArrayList<>();
        List<MethodSpec> serviceMethodSpecs = new ArrayList<>();
        for (Element e : serviceElements) {
            if (e.getKind() == CLASS) {
                TypeElement typeElement = (TypeElement) e;
                TypeName typeName = TypeVariableName.get("dagger.Lazy<" + typeElement.getQualifiedName() + ">");
                FieldSpec fieldSpec = FieldSpec.builder(typeName, getFieldName(typeElement)).addAnnotation(Class.forName("javax.inject.Inject")).build();
                serviceFieldSpecs.add(fieldSpec);
                MethodSpec methodSpec = MethodSpec.methodBuilder("get" + typeElement.getSimpleName())
                        .addModifiers(Modifier.PUBLIC)
                        .returns(TypeName.get(typeElement.asType()))
                        .addParameter()
                        .addCode(CodeBlock.builder().add("return ").add(getFieldName(typeElement)).add(".get();").add("\n").build())
                        .build();
                serviceMethodSpecs.add(methodSpec);
            }
        }
        String holderClassName = "ServiceHolder";
        TypeSpec holderTypeSpec = TypeSpec.classBuilder(holderClassName)
                .addModifiers(Modifier.PUBLIC)
                .addFields(serviceFieldSpecs)
                .addJavadoc(CodeBlock.builder().add("private static class InstanceHolder {").add("\n")
                        .add("private static " + holderClassName + " INSTANCE = new " + holderClassName + "();").add("\n")
                        .add("}").add("\n").build())
                .addJavadoc(CodeBlock.builder().add("public static " + holderClassName + " getInstance() {").add("\n")
                        .add("return " + holderClassName + ".InstanceHolder.INSTANCE;").add("\n")
                        .add("}").add("\n").build())
                .addMethods(serviceMethodSpecs)
                .build();
        JavaFile.builder("com.example.processor", holderTypeSpec).build().writeTo(mFiler);
    }

    private String getFieldName(TypeElement typeElement) {
        return "m" + typeElement.getSimpleName();
    }

    List<MethodSpec> injectMethodSpecs = new ArrayList<>();

    private void parseInject(Set<? extends Element> injectElements) throws IOException, ClassNotFoundException {
        for (Element e : injectElements) {
//            if (e.getKind() == INTERFACE || e.getKind() == CLASS) {
            TypeElement typeElement = (TypeElement) e;
            MethodSpec methodSpec = MethodSpec.methodBuilder("inject")
                    .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
                    .addParameter(ParameterSpec.builder(TypeName.get(typeElement.asType()), "c").build())
                    .returns(TypeName.VOID)
                    .build();
            injectMethodSpecs.add(methodSpec);
//            }
        }
    }

    private void parseComponent(Set<? extends Element> componentElements) throws IOException, ClassNotFoundException {
        AnnotationSpec componentAnnotationSpec = AnnotationSpec.builder(Class.forName("dagger.Component")).addMember("modules", codeBlockBuilder.build()).build();
        TypeSpec componentTypeSpec = TypeSpec.classBuilder("MMComponent" + System.currentTimeMillis())
                .addAnnotation(componentAnnotationSpec)
                .addAnnotation(Class.forName("javax.inject.Singleton"))
                .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
                .addMethods(injectMethodSpecs)
                .build();
        JavaFile.builder("com.example.processor", componentTypeSpec).build().writeTo(mFiler);
    }

    CodeBlock.Builder codeBlockBuilder;

    /**
     * 注解：scope/Component(参数：被MutliModule注解的类的class)
     * 类描述：public abstract class Communication_Component
     * 方法：public abstract void inject(MainServiceCollection mainServiceColleation);
     * MainServiceCollection：被
     */
    private void parseModules(Set<? extends Element> modulesElements) throws IOException, ClassNotFoundException {
        codeBlockBuilder = CodeBlock.builder().add("{");
        for (Element e : modulesElements) {
            if (e.getKind() == CLASS) {
                TypeElement typeElement = (TypeElement) e;
                codeBlockBuilder.add(typeElement.getQualifiedName().toString() + ".class").add(",");
            }
        }
        codeBlockBuilder.add("}");
    }
}
