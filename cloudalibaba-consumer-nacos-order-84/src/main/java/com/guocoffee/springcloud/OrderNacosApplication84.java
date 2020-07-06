package com.guocoffee.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @program: springcloud
 * @description:
 * @author: guo-coffee
 * @create: 2020-07-06
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients // 激活并开启feign
public class OrderNacosApplication84 {

    public static void main(String[] args) {
        SpringApplication.run(OrderNacosApplication84.class,args);
    }
}
