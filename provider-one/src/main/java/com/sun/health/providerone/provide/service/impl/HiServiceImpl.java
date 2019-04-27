package com.sun.health.providerone.provide.service.impl;

import com.sun.health.providerone.provide.service.HiService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Service(version = "1.0.0")
@Component
public class HiServiceImpl implements HiService {

    @Value("${dubbo.application.name}")
    private String providerName;

    @Override
    public String sayHi(String name) {
        String result = "Default Hi " + name + "!Welcome to " + providerName + ".";
        System.out.println(result);
        return result;
    }
}
