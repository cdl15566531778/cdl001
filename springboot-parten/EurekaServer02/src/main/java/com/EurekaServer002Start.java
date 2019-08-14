package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer  //运行当前应用作为EurekaServer来启动
public class EurekaServer002Start {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer002Start.class,args);
    }
}
