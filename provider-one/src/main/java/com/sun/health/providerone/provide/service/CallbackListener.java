package com.sun.health.providerone.provide.service;

import java.io.Serializable;

public interface CallbackListener extends Serializable {
    void changed(String msg);
}
