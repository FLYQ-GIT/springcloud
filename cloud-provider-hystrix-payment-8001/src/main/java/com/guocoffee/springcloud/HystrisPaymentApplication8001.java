package com.guocoffee.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @program: springcloud
 * @description: 主启动类
 * @author: guo-coffee
 * @create: 2020-07-02
 */
@SpringBootApplication
@EnableEurekaClient // 标示为Eureka客户端
@EnableCircuitBreaker //
public class HystrisPaymentApplication8001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrisPaymentApplication8001.class,args);
    }
}
