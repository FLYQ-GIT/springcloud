package com.guocoffee.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @program: springcloud
 * @description: 主启动类
 * @author: guo-coffee
 * @create: 2020-07-02
 */
@SpringBootApplication
@EnableEurekaClient // 标示为Eureka客户端
@EnableDiscoveryClient
public class PaymentApplication8002 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication8002.class,args);
    }
}
