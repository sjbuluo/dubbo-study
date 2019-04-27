package com.sun.health.providerone.provide.service;

import java.util.concurrent.CompletableFuture;

public interface HiService {
    String sayHi(String name);

    default CompletableFuture<String> sayHi(String name, Object signal) {
        return CompletableFuture.completedFuture(sayHi(name));
    }
}
