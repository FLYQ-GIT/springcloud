package com.guocoffee.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @program: springcloud
 * @description: spring-cloud-config服务端
 * @author: guo-coffee
 * @create: 2020-07-04
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigCenterApplication3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterApplication3344.class,args);
    }
}
