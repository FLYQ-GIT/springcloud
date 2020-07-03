package com.guocoffee.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @program: springcloud
 * @description:
 * @author: guo-coffee
 * @create: 2020-07-03
 */
@SpringBootApplication
@EnableHystrixDashboard
public class DashBoardApplication9001 {
    // http://localhost:9001/hystrix访问地址
    public static void main(String[] args) {
        SpringApplication.run(DashBoardApplication9001.class,args);
    }
}
