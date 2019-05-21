package com.bill.base.service;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;

public interface EService {
    void startActivity();

    void startActivity(@NonNull Activity activity);

    void startActivityForResult(@NonNull Activity activity, int requestCode);
}
