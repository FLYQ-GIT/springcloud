package com.guocoffee.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: springcloud
 * @description:
 * @author: guo-coffee
 * @create: 2020-07-06
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderNacosApplication84 {

    public static void main(String[] args) {
        SpringApplication.run(OrderNacosApplication84.class,args);
    }
}
