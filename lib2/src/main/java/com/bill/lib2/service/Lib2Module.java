package com.bill.lib2.service;

import com.bill.base.service.EService;
import com.bill.base.service.IServiceScope;
import com.bill.base.service.WService;
import com.bill.multi.annotation.MutliModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@MutliModule
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
