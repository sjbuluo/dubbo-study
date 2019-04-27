package com.sun.health.providerone.provide.service.impl;

import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.rpc.service.GenericException;
import org.apache.dubbo.rpc.service.GenericService;
import org.springframework.stereotype.Component;

@Service(interfaceName = "com.sun.SorryService", version = "1.0.0")
@Component
public class CustomGenericService implements GenericService {
    @Override
    public Object $invoke(String s, String[] strings, Object[] objects) throws GenericException {
        switch (s) {
            case "sorry":
                return "sorry " + objects[0];
        }
        return null;
    }
}
