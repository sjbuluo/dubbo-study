package com.sun.health.providerone.provide.service;

import java.io.Serializable;

@FunctionalInterface
public interface CallbackListener extends Serializable {
    void changed(String msg);
}
