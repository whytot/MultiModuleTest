package com.bill.multimoduletest;

import android.app.Application;

import com.bill.base.BaseLib;
import com.bill.base.MainService;
import com.bill.base.MainServiceColleation;
import com.bill.lib2.Lib2;
import com.bill.multimoduletest.injection.DaggerCommunicationComponent;

public class App extends Application {
    private static final String TAG = "App";
    private static App appInstance;

    public static synchronized App getInstance() {
        return appInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerCommunicationComponent.create().inject(MainServiceColleation.getInstance());
        appInstance = this;
        Lib2.getInstance().init(this);
        BaseLib.getInstance().init();
    }
}
