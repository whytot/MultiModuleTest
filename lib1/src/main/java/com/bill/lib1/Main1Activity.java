package com.bill.lib1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.bill.base.MainService;

public class Main1Activity extends AppCompatActivity {
    private static final String TAG = "Main1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        Log.e(TAG, MainService.getInstance().lib2Say());
    }

    public void onClick1(View view) {
        MainService.getInstance().lib2Do(this, 1111);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e(TAG, "onActivityResult: [ requestCode - " + requestCode + " ; resultCode - " + resultCode + " ]");
    }
}
