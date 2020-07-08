package com.guocoffee.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @program: springcloud
 * @description:
 * @author: guo-coffee
 * @create: 2020-07-08
 */
@EnableDiscoveryClient
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) // 排除DataSource自动配置，使用DataSourceProxyConfig自定义配置，使用seata
@EnableFeignClients
public class StorageServiceApplication2002 {

    public static void main(String[] args) {
        SpringApplication.run(StorageServiceApplication2002.class,args);
    }
}
