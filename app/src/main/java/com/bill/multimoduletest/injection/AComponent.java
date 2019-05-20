package com.bill.multimoduletest.injection;

import com.bill.base.injection.BaseComponent;
import com.bill.lib1.service.Lib1Module;
import com.bill.lib2.service.Lib2Module;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {Lib1Module.class, Lib2Module.class})
public abstract class AComponent extends BaseComponent {

}
