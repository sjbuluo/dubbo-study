package com.sun.health.providerone.provide.service;

import java.io.Serializable;

public interface CallbackService {
    void addListener(String key, CallbackListener callbackListener);
}
