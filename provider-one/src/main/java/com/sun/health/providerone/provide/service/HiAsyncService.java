package com.sun.health.providerone.provide.service;

import java.util.concurrent.CompletableFuture;

public interface HiAsyncService {
    CompletableFuture<String> sayHi(String name);
}
