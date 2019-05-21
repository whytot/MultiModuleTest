package com.bill.lib2.service;

import com.bill.base.service.EService;
import com.bill.base.service.WService;

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
