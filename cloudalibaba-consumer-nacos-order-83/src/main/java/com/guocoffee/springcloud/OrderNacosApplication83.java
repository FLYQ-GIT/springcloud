package com.guocoffee.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: springcloud
 * @description:
 * @author: guo-coffee
 * @create: 2020-07-04
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderNacosApplication83 {

    public static void main(String[] args) {
        SpringApplication.run(OrderNacosApplication83.class,args);
    }
}
