package com.sun.health.providerone.provide.service.impl;

import com.sun.health.providerone.provide.service.StubService;
import org.apache.dubbo.config.annotation.Service;

@Service
public class StubServiceStub implements StubService {
    private StubService stubService;

    public StubServiceStub(StubService stubService) {
        this.stubService = stubService;
    }

    @Override
    public String sayHello(String name) {
        try {
            return stubService.sayHello(name);
        } catch (Exception e) {
            return "容错";
        }
    }
}
