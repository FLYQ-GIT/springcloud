package com.guocoffee.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @program: springcloud
 * @description:
 * @author: guo-coffee
 * @create: 2020-07-02
 */
@SpringBootApplication
@EnableEurekaServer // 标示为Eureka服务端
public class EurekaServiceApplication7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServiceApplication7002.class,args);
    }
}
