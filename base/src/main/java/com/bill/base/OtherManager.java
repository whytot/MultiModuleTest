package com.bill.base;

import android.util.Log;

import javax.inject.Inject;

public class OtherManager {
    private static final String TAG = "Other";

    //    @Inject
    public OtherManager() {
    }

    public String baseSay() {
        return "i am OtherManager. ( " + this + " )";
    }
}
