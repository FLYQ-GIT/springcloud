package com.guocoffee.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @program: springcloud
 * @description:
 * @author: guo-coffee
 * @create: 2020-07-02
 */
@SpringBootApplication
@EnableFeignClients // 激活并开启feign
public class OrderFeignApplication80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderFeignApplication80.class,args);
    }
}
