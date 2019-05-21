package com.bill.lib2.injection;

import com.bill.base.injection.BaseComponent;
import com.bill.lib2.Main2Activity;

import dagger.Component;

@Lib2Scope
@Component(dependencies = BaseComponent.class)
public abstract class Lib2Component {
    public abstract void inject(Main2Activity main2Activity);
}
