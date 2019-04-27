package com.sun.health.consumerone.consume;

import org.apache.dubbo.rpc.RpcContext;
import org.apache.dubbo.rpc.service.EchoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EchoTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void test1() {
        EchoService echoService = (EchoService) applicationContext.getBean("com.sun.health.providerone.provide.service.HelloService");
        Object status = echoService.$echo("ok");
        assert(status.equals("ok"));
    }

}
