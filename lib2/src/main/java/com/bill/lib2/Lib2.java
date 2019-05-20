package com.bill.lib2;

import android.app.Application;

public class Lib2 {
    private static class InstanceHolder {
        private static Lib2 INSTANCE = new Lib2();
    }

    public static Lib2 getInstance() {
        return Lib2.InstanceHolder.INSTANCE;
    }

    private Application mApplication;

    public void init(Application application) {
        mApplication = application;
    }

    public Application getApplication() {
        return mApplication;
    }
}
