package com.bill.lib2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.bill.base.MainService;

public class Main2Activity extends AppCompatActivity {
    private static final String TAG = "Main2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.e(TAG, MainService.getInstance().lib1Say());
    }
}
