package com.sun.health.providerone.provide.service.impl;

import com.sun.health.providerone.provide.service.CallbackListener;
import com.sun.health.providerone.provide.service.CallbackService;
import org.apache.dubbo.config.annotation.Argument;
import org.apache.dubbo.config.annotation.Method;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

@Service(version = "1.0.0", methods = {
        @Method(name = "addListener", arguments = {
                @Argument(index = 1, callback = true, type = "com.sun.health.providerone.provide.service.CallbackListener")
        })
}, connections = 1, callbacks = 100)
@Component
public class CallbackServiceImpl implements CallbackService {

    private Map<String, CallbackListener> map = new ConcurrentHashMap<>();

    public CallbackServiceImpl() {
        Thread thread = new Thread(() -> {
            while (true) {
                for (Map.Entry<String, CallbackListener> stringCallbackServiceEntry : map.entrySet()) {
                    try {
                        stringCallbackServiceEntry.getValue().changed(getChanged(stringCallbackServiceEntry.getKey()));
                    } catch (Throwable e) {
                        e.printStackTrace();
                        map.remove(stringCallbackServiceEntry.getKey());
                    }
                }
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

    @Override
    public void addListener(String key, CallbackListener callbackListener) {
        this.map.put(key, callbackListener);
        callbackListener.changed(getChanged(key));
    }

    private String getChanged(String key) {
        return key + " changed: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

}
