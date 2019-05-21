package com.bill.lib1.injection;

import com.bill.base.injection.BaseComponent;
import com.bill.base.service.MainServiceCollection;
import com.bill.lib1.Main1Activity;
import com.bill.lib1.service.QServiceImpl;

import dagger.Component;

@Lib1Scope
@Component(dependencies = BaseComponent.class)
public abstract class Lib1Component {

    private static class InstanceHolder {
        private static Lib1Component INSTANCE = DaggerLib1Component.builder().baseComponent(BaseComponent.getInstance()).build();
    }

    public static Lib1Component getInstance() {
        return Lib1Component.InstanceHolder.INSTANCE;
    }

    public abstract void inject(Main1Activity main1Activity);

    public abstract void inject(QServiceImpl qService);
}
