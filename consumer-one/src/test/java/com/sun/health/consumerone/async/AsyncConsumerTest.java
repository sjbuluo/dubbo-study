package com.sun.health.consumerone.async;

import com.sun.health.providerone.provide.service.HiAsyncService;
import com.sun.health.providerone.provide.service.HiService;

import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CompletableFuture;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AsyncConsumerTest {

    @Reference(version = "1.0.0")
    private HiService hiService;

    @Reference(version = "1.0.0")
    private HiAsyncService hiAsyncService;

    @Test
    public void test1() {
        CompletableFuture<String> stringCompletableFuture = hiService.sayHi("SJ");
        stringCompletableFuture.whenComplete((response, err) -> {
           if(err != null) {
               err.printStackTrace();
           } else {
               System.out.println(response);
           }
        });
        System.out.println("先退出");
        System.out.println(123);
    }

    @Test
    public void test2() {
        CompletableFuture<String> stringCompletableFuture = hiAsyncService.sayHi("SJ");
        stringCompletableFuture.whenComplete((response, err) -> {
            if(err != null) {
                err.printStackTrace();
            } else {
                System.out.println(response);
            }
        });
        System.out.println("先退出");
        System.out.println(123);
    }

}
