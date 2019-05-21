package com.bill.base;

import android.util.Log;

import javax.inject.Inject;

public class OtherManager {
    private static final String TAG = "Other";

//    @Inject
    public OtherManager() {
    }

    public void baseSay() {
        Log.e(TAG, "i am base. ( " + this + " )");
    }
}
