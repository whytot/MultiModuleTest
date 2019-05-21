package com.bill.lib2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.bill.base.injection.BaseComponent;
import com.bill.base.service.MainService;
import com.bill.lib2.injection.DaggerLib2Component;

import javax.inject.Inject;

public class Main2Activity extends AppCompatActivity {
    private static final String TAG = "Main2";

    @Inject
    MainService mainService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        DaggerLib2Component.builder().baseComponent(BaseComponent.getInstance()).build().inject(this);
        Log.e(TAG, mainService.lib1Say());
    }
}
