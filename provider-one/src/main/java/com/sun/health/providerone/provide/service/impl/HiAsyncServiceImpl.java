package com.sun.health.providerone.provide.service.impl;

import com.sun.health.providerone.provide.service.HiAsyncService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Service(version = "1.0.0")
@Component
public class HiAsyncServiceImpl implements HiAsyncService {
    @Value("${dubbo.application.name}")
    private String providerName;
    @Override
    public CompletableFuture<String> sayHi(String name) {
        String result = "Async Hi " + name + "!Welcome to " + providerName + ".";
        System.out.println(result);
        return CompletableFuture.completedFuture(result);
    }
}
