package com.bill.lib2.service;

import com.bill.base.EService;
import com.bill.base.WService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class Lib2Module {
    @Singleton
    @Provides
    public WService provideWService() {
        return new WServiceImpl();
    }

    @Singleton
    @Provides
    public EService provideEService() {
        return new EServiceImpl();
    }
}
