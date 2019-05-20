package com.bill.lib2.service;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;

import com.bill.base.EService;
import com.bill.lib2.Lib2;
import com.bill.lib2.Main2Activity;

public class EServiceImpl implements EService {
    /**
     * context: application
     */
    @Override
    public void startActivity() {
        Context context = Lib2.getInstance().getApplication();
        ActivityCompat.startActivity(context, new Intent(context, Main2Activity.class), null);
    }

    /**
     * 普通
     */
    @Override
    public void startActivity(@NonNull Activity activity) {
        ActivityCompat.startActivity(activity, new Intent(activity, Main2Activity.class), null);
    }

    /**
     * for result
     */
    @Override
    public void startActivityForResult(@NonNull Activity activity, int requestCode) {
        ActivityCompat.startActivityForResult(activity, new Intent(activity, Main2Activity.class), requestCode, null);
    }
}
