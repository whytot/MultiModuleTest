package com.bill.base;

import android.app.Activity;

import javax.inject.Inject;

import dagger.Lazy;

public class MainService {

    private static class InstanceHolder {
        private static MainService INSTANCE = new MainService();
    }

    public static MainService getInstance() {
        return MainService.InstanceHolder.INSTANCE;
    }

    @Inject
    Lazy<QService> qService;

    public String lib1Say() {
        return qService.get().say();
    }

    @Inject
    Lazy<WService> wService;

    public String lib2Say() {
        return wService.get().say();
    }

    @Inject
    Lazy<EService> eService;

    public void lib2Do(Activity activity, int requestCode) {
        eService.get().startActivityForResult(activity, requestCode);
    }
}
