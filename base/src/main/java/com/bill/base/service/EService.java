package com.bill.base.service;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.bill.multi.annotation.MultiService;

@MultiService
public abstract class EService {
    public abstract void startActivity();

    public abstract void startActivity(@NonNull Activity activity);

    public abstract void startActivityForResult(@NonNull Activity activity, int requestCode);
}
