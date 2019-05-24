package com.bill.multimoduletest;

import android.app.Application;

import com.bill.base.BaseLib;
import com.bill.base.service.MainServiceCollection;
import com.bill.lib2.Lib2;
import com.bill.multi.annotation.MutliComponent;
import com.bill.multimoduletest.injection.DaggerCommunicationComponent;

@MutliComponent
public class App extends Application {
    private static final String TAG = "App";
    private static App appInstance;

    public static synchronized App getInstance() {
        return appInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerCommunicationComponent.create().inject(MainServiceCollection.getInstance());
        appInstance = this;
        Lib2.getInstance().init(this);
        BaseLib.getInstance().init();
    }
}
