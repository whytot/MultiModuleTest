package com.bill.base.injection;

import com.bill.base.BaseLib;
import com.bill.base.service.MainService;
import com.bill.base.OtherManager;

import dagger.Component;

@AppScope
@Component(modules = BaseModule.class)
public abstract class BaseComponent {

    private static class InstanceHolder {
        private static BaseComponent INSTANCE = DaggerBaseComponent.create();
    }

    public static BaseComponent getInstance() {
        return BaseComponent.InstanceHolder.INSTANCE;
    }

    public abstract void inject(BaseLib baseLib);

    public abstract void inject(MainService mainService);

    public abstract OtherManager getOtherManager();

    public abstract MainService getMainService();
}
