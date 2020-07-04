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
public class ConfigNacosApplication3377 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigNacosApplication3377.class,args);
    }
}
