package com.bill.lib1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.bill.base.service.MainService;
import com.bill.base.OtherManager;
import com.bill.base.injection.BaseComponent;
import com.bill.lib1.injection.DaggerLib1Component;
import com.bill.lib1.injection.Lib1Component;

import javax.inject.Inject;

public class Main1Activity extends AppCompatActivity {
    private static final String TAG = "Main1";
    @Inject
    OtherManager otherManager;
    @Inject
    MainService mainService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        Lib1Component.getInstance().inject(this);
        Log.e(TAG, otherManager.baseSay());
        Log.e(TAG, mainService.lib2Say());
    }

    public void onClick1(View view) {
        mainService.lib2Do(this, 1111);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e(TAG, "onActivityResult: [ requestCode - " + requestCode + " ; resultCode - " + resultCode + " ]");
    }
}
