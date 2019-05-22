package com.bill.lib2.service;

import com.bill.base.service.EService;
import com.bill.base.service.IServiceScope;
import com.bill.base.service.WService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class Lib2Module {
    @IServiceScope
    @Provides
    public WService provideWService() {
        return new WServiceImpl();
    }

    @IServiceScope
    @Provides
    public EService provideEService() {
        return new EServiceImpl();
    }
}
