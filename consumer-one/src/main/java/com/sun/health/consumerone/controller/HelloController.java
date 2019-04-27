package com.sun.health.consumerone.controller;

import com.sun.health.providerone.provide.service.CallbackListener;
import com.sun.health.providerone.provide.service.CallbackService;
import com.sun.health.providerone.provide.service.HelloService;
import com.sun.health.providerone.provide.service.StubService;
import org.apache.dubbo.config.annotation.Method;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.support.Parameter;
import org.apache.dubbo.rpc.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Reference(version = "1.0.0", mock = "com.sun.health.providerone.provide.service.impl.HelloServiceMock")
    private HelloService helloService;

    @Reference(version = "1.0.0", generic = true, interfaceName = "com.sun.SorryService")
    private GenericService genericService;

//    @Reference(version = "1.0.0")
//    private CallbackService callbackService;

    @Reference(stub = "com.sun.health.providerone.provide.service.impl.StubServiceStub")
    private StubService stubService;

    @Autowired
    private ApplicationContext applicationContext;

    @RequestMapping("/hello")
    public String hello(@RequestParam(required = false, defaultValue = "World") String name) {
        return helloService.hello(name);
    }

    @RequestMapping("/stub")
    public String sub() {
        return stubService.sayHello("abc");
    }

//    @RequestMapping("/callback")
//    public String callback() {
//        callbackService.addListener("consumer-one", new CallbackListener() {
//            private final Long serialVersionUID = 1L;
//            @Override
//            public void changed(String msg) {
//                System.out.println(msg);
//            }
//        });
//        return "ok";
//    }

}
