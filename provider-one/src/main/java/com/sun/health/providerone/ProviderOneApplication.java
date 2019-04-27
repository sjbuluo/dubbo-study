package com.sun.health.providerone;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableAutoConfiguration
@DubboComponentScan({"com.sun.health.providerone.provide.service.impl"})
public class ProviderOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProviderOneApplication.class, args);
	}

}
