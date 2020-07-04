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
// curl -X POST "http://localhost:3344/actuator/bus-refresh" 刷新3344，通过RabbitMQ广播到3355和3366，实现自动动态刷新
// curl -X POST "http://localhost:3344/actuator/bus-refresh/config-client:3355" 定点通知(疑问：多个怎么处理)
// config-client:3355（spring.application.name）:(端口)
public class ConfigCenterApplication3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterApplication3344.class,args);
    }
}
