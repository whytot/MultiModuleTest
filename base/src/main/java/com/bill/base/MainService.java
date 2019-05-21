package com.bill.base;

import android.app.Activity;

import javax.inject.Inject;

/**
 * 总服务
 * <p>
 * 不在直接被通信组件注入，而是持有一个所有服务的集合
 */
public class MainService {

    private static class InstanceHolder {
        private static MainService INSTANCE = new MainService();
    }

    public static MainService getInstance() {
        return MainService.InstanceHolder.INSTANCE;
    }

    @Inject
    OtherManager otherManager;


    public String lib1Say() {
        otherManager.baseSay();
        return MainServiceColleation.getInstance().getQService().say();
    }

    public String lib2Say() {
        otherManager.baseSay();
        return MainServiceColleation.getInstance().getWService().say();
    }

    public void lib2Do(Activity activity, int requestCode) {
        otherManager.baseSay();
        MainServiceColleation.getInstance().getEService().startActivityForResult(activity, requestCode);
    }
}
