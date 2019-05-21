package com.bill.lib1;

import android.app.Application;

public class Lib1 {
    private static class InstanceHolder {
        private static Lib1 INSTANCE = new Lib1();
    }

    public static Lib1 getInstance() {
        return Lib1.InstanceHolder.INSTANCE;
    }

    private Application mApplication;

    public void init(Application application) {
        mApplication = application;
    }

    public Application getApplication() {
        return mApplication;
    }
}
