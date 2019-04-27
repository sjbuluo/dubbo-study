package com.sun.health.providerone.provide.service.impl;

import com.sun.health.providerone.provide.service.StubService;
import org.apache.dubbo.config.annotation.Service;

import java.util.Random;

@Service()
public class StubServiceImpl implements StubService {
    @Override
    public String sayHello(String name) throws Exception {
        if(new Random().nextBoolean()) {
            return name;
        } else {
            throw new Exception("123");
        }
    }
}
