package com.bill.lib1.service;

import android.util.Log;

import com.bill.base.service.QService;
import com.bill.lib1.Lib1Manager;
import com.bill.lib1.injection.Lib1Component;

import javax.inject.Inject;

/**
 * 被注入其他依赖
 */
public class QServiceImpl extends QService {
    private static final String TAG = "QServiceImpl";
    @Inject
    Lib1Manager lib1Manager;

    public QServiceImpl() {
        Lib1Component.getInstance().inject(this);
    }

    @Override
    public String say() {
        Log.e(TAG, lib1Manager.say());
        return "我是lib1提供的QService" + this;
    }
}
