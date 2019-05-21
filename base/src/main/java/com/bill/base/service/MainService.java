package com.bill.base.service;

import android.app.Activity;
import android.util.Log;

import com.bill.base.OtherManager;

import javax.inject.Inject;

/**
 * 总服务
 * <p>
 * 不在直接被通信组件注入，而是持有一个所有服务的集合
 */
public class MainService {

    private static final String TAG = "MainService";

//    private static class InstanceHolder {
//        private static MainService INSTANCE = new MainService();
//    }
//
//    public static MainService getInstance() {
//        return MainService.InstanceHolder.INSTANCE;
//    }

    @Inject
    public MainService(OtherManager otherManager) {
        this.otherManager = otherManager;
    }

    OtherManager otherManager;


    public String lib1Say() {
        Log.e(TAG, otherManager.baseSay());
        return MainServiceColleation.getInstance().getQService().say();
    }

    public String lib2Say() {
        Log.e(TAG, otherManager.baseSay());
        return MainServiceColleation.getInstance().getWService().say();
    }

    public void lib2Do(Activity activity, int requestCode) {
        Log.e(TAG, otherManager.baseSay());
        MainServiceColleation.getInstance().getEService().startActivityForResult(activity, requestCode);
    }
}
