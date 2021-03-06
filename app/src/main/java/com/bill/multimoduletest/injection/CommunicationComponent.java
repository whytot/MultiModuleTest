package com.bill.multimoduletest.injection;

import com.bill.base.service.IServiceScope;
import com.bill.base.service.MainServiceCollection;
import com.bill.lib1.service.Lib1Module;
import com.bill.lib2.service.Lib2Module;

import javax.inject.Singleton;

import dagger.Component;

/**
 * CommunicationComponent 不在依赖BaseComponent
 */
@IServiceScope
@Component(modules = {Lib1Module.class, Lib2Module.class})
public abstract class CommunicationComponent {
    public abstract void inject(MainServiceCollection mainServiceColleation);
}
