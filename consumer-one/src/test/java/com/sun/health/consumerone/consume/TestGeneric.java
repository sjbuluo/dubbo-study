package com.sun.health.consumerone.consume;

import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.annotation.Reference;
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
        ReferenceConfig<GenericService> genericServiceReferenceConfig = new ReferenceConfig<>();
        genericServiceReferenceConfig.setInterface("com.sun.health.providerone.provide.service.HelloService");
        genericServiceReferenceConfig.setVersion("1.0.0");
        genericServiceReferenceConfig.setGeneric(true);
        GenericService genericService = genericServiceReferenceConfig.get();
        Object hello = genericService.$invoke("hello", new String[]{"java.lang.String"}, new Object[]{"孙健"});
        System.out.println(hello);
    }

    @Test
    public void test2() {
        ReferenceConfig<GenericService> genericServiceReferenceConfig = new ReferenceConfig<>();
        genericServiceReferenceConfig.setInterface("com.sun.SorryService");
        genericServiceReferenceConfig.setVersion("1.0.0");
        genericServiceReferenceConfig.setGeneric(true);
        GenericService genericService = genericServiceReferenceConfig.get();
        Object hello = genericService.$invoke("sorry", new String[]{"java.lang.String"}, new Object[]{"孙健"});
        System.out.println(hello);
    }



}
