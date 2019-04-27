package com.sun.health.providerone.provide.service;

import java.util.concurrent.CompletableFuture;

public interface HiService {
    CompletableFuture<String> sayHi(String name);
}
