package com.sun.health.providerone.provide.service.impl;

import com.sun.health.providerone.provide.service.HelloService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Service(version = "1.0.0")
@Component
public class HelloServiceImpl implements HelloService {

    @Value("${dubbo.application.name}")
    private String providerName;

    @Override
    public String hello(String name) {
        String result = "Hello " + name + "! Welcome to " + providerName + ".";
        System.out.println(name);
        return name;
    }
}
