package com.official.jetsetstay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class JetSetStayServiceDiscoveryApplication {

    public static void main(String[] args) {

        SpringApplication.run(JetSetStayServiceDiscoveryApplication.class, args);
    }

}
