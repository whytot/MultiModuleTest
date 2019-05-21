package com.bill.lib1.injection;

import com.bill.base.injection.BaseComponent;
import com.bill.lib1.Main1Activity;

import dagger.Component;

@Lib1Scope
@Component(dependencies = BaseComponent.class)
public abstract class Lib1Component {
    public abstract void inject(Main1Activity main1Activity);
}
