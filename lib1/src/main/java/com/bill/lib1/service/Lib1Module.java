package com.bill.lib1.service;

import com.bill.base.service.IServiceScope;
import com.bill.base.service.QService;
import com.bill.multi.annotation.MutliModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@MutliModule
@Module
public class Lib1Module {
    @Singleton
    @Provides
    public QService provideQService() {
        return new QServiceImpl();
    }
}
