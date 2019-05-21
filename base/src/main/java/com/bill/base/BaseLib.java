package com.bill.base;

import com.bill.base.injection.BaseComponent;
import com.bill.base.service.MainService;

import javax.inject.Inject;

public class BaseLib {

    private static class InstanceHolder {
        private static BaseLib INSTANCE = new BaseLib();
    }

    public static BaseLib getInstance() {
        return BaseLib.InstanceHolder.INSTANCE;
    }

    @Inject
    MainService mainService;

    public void init() {
        BaseComponent.getInstance().inject(this);
        BaseComponent.getInstance().inject(mainService);
    }
}
