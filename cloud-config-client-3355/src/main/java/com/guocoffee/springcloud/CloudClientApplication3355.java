package com.guocoffee.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @program: springcloud
 * @description: spring-cloud-config客户端
 * @author: guo-coffee
 * @create: 2020-07-04
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudClientApplication3355 {
    public static void main(String[] args) {
        SpringApplication.run(CloudClientApplication3355.class,args);
    }
}
