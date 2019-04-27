package com.sun.health.providerone.provide.service.impl;

import com.sun.health.providerone.provide.service.HelloService;

public class HelloServiceMock implements HelloService {
    @Override
    public String hello(String name) {
        return "Mock 容错";
    }
}
