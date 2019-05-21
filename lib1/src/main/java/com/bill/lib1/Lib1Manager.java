package com.bill.lib1;

import android.util.Log;

import com.bill.base.OtherManager;

import javax.inject.Inject;

public class Lib1Manager {
    private static final String TAG = "Lib1Manager";
    OtherManager otherManager;

    @Inject
    public Lib1Manager(OtherManager otherManager) {
        this.otherManager = otherManager;
    }

    public String say() {
        Log.e(TAG, otherManager.baseSay());
        return "i am Lib1Manager. ( " + this + " )";
    }
}
