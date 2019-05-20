package com.bill.multimoduletest;

import android.app.Application;

import com.bill.base.MainService;
import com.bill.lib2.Lib2;
import com.bill.multimoduletest.injection.DaggerAComponent;

public class App extends Application {
    private static final String TAG = "App";
    private static App appInstance;

    public static synchronized App getInstance() {
        return appInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAComponent.create().inject(MainService.getInstance());
        appInstance = this;
        Lib2.getInstance().init(this);
    }
}
