package com.guocoffee.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @program: springcloud
 * @description:
 * @author: guo-coffee
 * @create: 2020-07-04
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamMQApplication8803 {
    public static void main(String[] args) {
        SpringApplication.run(StreamMQApplication8803.class,args);
    }
}
