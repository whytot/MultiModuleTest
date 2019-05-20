package com.bill.multimoduletest.injection;

import com.bill.base.injection.BaseComponent;
import com.bill.lib1.service.XModule;
import com.bill.lib2.service.CModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {XModule.class, CModule.class})
public abstract class AComponent extends BaseComponent {

}
