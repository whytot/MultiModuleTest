package com.bill.base.service;

import javax.inject.Inject;

import dagger.Lazy;

/**
 * 一个集合所有服务实例的集合
 * <p>
 * 所有服务和总服务的中间层，由于这一层提供的服务都是懒加载，所以直接提供单例影响不大
 */
class MainServiceCollection {

    private static class InstanceHolder {
        private static MainServiceCollection INSTANCE = new MainServiceCollection();
    }

    public static MainServiceCollection getInstance() {
        return MainServiceCollection.InstanceHolder.INSTANCE;
    }

    @Inject
    Lazy<QService> qService;

    @Inject
    Lazy<WService> wService;

    @Inject
    Lazy<EService> eService;

    public QService getQService() {
        return qService.get();
    }

    public WService getWService() {
        return wService.get();
    }

    public EService getEService() {
        return eService.get();
    }
}
