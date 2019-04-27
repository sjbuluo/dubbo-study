package com.sun.health.consumerone.callback;

import com.sun.health.providerone.provide.service.CallbackListener;
import com.sun.health.providerone.provide.service.CallbackService;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CallbackTest implements Serializable {

    @Reference(version = "1.0.0")
    private CallbackService callbackService;

    private ApplicationContext applicationContext;

    @Test
    public void test1() {
        callbackService.addListener("consumer-one", new CallbackListener() {
            @Override
            public void changed(String msg) {
                System.out.println(msg);
            }
        });
    }

    @Test
    public void test2() {
        CallbackService callbackService = (CallbackService) applicationContext.getBean("com.sun.health.providerone.provide.service.CallbackService");
        callbackService.addListener("consumer-one", new CallbackListener() {
            @Override
            public void changed(String msg) {
                System.out.println(msg);
            }
        });
    }




}
