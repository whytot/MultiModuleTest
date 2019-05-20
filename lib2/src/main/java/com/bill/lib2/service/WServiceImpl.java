package com.bill.lib2.service;

import com.bill.base.WService;

public class WServiceImpl implements WService {
    @Override
    public String say() {
        return "我是lib2提供的WService";
    }
}
