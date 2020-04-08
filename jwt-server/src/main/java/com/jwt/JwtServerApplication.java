package com.jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class JwtServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtServerApplication.class, args);
    }

}
