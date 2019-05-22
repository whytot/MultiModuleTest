package com.bill.lib1.service;

import com.bill.base.service.IServiceScope;
import com.bill.base.service.QService;

import dagger.Module;
import dagger.Provides;

@Module
public class Lib1Module {
    @IServiceScope
    @Provides
    public QService provideQService() {
        return new QServiceImpl();
    }
}
