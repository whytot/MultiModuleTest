package com.bill.base.injection;

import com.bill.base.OtherManager;

import dagger.Module;
import dagger.Provides;

@Module
public class BaseModule {
    @AppScope
    @Provides
    public OtherManager provideOtherManager() {
        return new OtherManager();
    }
}
