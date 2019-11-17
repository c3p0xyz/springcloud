package com.liu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DeptProviderConfig8001_App  {

    public static void main(String[] args) {
        SpringApplication.run(DeptProviderConfig8001_App.class, args);
    }

}
