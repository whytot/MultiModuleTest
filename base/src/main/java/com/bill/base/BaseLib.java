package com.bill.base;

import com.bill.base.injection.BaseComponent;
import com.bill.base.injection.DaggerBaseComponent;

public class BaseLib {

    private static class InstanceHolder {
        private static BaseLib INSTANCE = new BaseLib();
    }

    public static BaseLib getInstance() {
        return BaseLib.InstanceHolder.INSTANCE;
    }

    public void init() {
        BaseComponent.getInstance().inject(MainService.getInstance());
    }
}
