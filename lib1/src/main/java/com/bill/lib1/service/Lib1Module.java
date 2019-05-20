package com.bill.lib1.service;

import com.bill.base.QService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class Lib1Module {
    @Singleton
    @Provides
    public QService provideQService() {
        return new QServiceImpl();
    }
}
