package com.bill.multimoduletest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bill.lib1.Main1Activity;
import com.bill.lib2.Main2Activity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick1(View view) {
        startActivity(new Intent(this, Main1Activity.class));
    }

    public void onClick2(View view) {
        startActivity(new Intent(this, Main2Activity.class));
    }
}
