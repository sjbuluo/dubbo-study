package com.sun.health.providerone.provide;

import com.sun.health.providerone.provide.service.impl.CustomGenericService;
import org.apache.dubbo.config.ServiceConfig;
import org.apache.dubbo.rpc.service.GenericService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestGeneric {

    @Test
    public void test1() {
        ServiceConfig<GenericService> serviceConfig = new ServiceConfig<>();
        serviceConfig.setInterface("com.sun.health.providerone.provide.service.impl.SorryService");
        serviceConfig.setVersion("1.0.0");
        serviceConfig.setRef(new CustomGenericService());
        serviceConfig.export();
        System.out.println(123);
    }
}
