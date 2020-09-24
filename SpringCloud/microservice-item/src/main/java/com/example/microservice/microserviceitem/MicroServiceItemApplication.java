package com.example.microservice.microserviceitem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroServiceItemApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceItemApplication.class, args);
    }

}
