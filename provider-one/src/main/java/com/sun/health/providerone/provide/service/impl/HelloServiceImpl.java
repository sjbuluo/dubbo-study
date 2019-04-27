package com.sun.health.providerone.provide.service.impl;

import com.sun.health.providerone.provide.service.HelloService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Service(version = "${dubbo.service.version}")
@Component
public class HelloServiceImpl implements HelloService {

    @Value("${dubbo.application.name}")
    private String providerName;

    @Override
    public String hello(String name) {
        return "Hello " + name + "! Welcome to " + providerName + ".";
    }
}
