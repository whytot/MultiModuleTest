package com.bill.lib1.service;

import com.bill.base.service.QService;

public class QServiceImpl implements QService {
    @Override
    public String say() {
        return "我是lib1提供的QService";
    }
}
