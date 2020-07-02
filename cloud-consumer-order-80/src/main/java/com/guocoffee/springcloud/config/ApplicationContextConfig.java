package com.guocoffee.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @program: springcloud
 * @description: 注入RestTemplate，通过RestTemplate完成远程调用
 * @author: guo-coffee
 * @create: 2020-07-02
 */
@Configuration
public class ApplicationContextConfig {

    /**
     * @Bean 通过注解注入RestTemplate
     * @return
     */
    @Bean
    @LoadBalanced   // 通过此注解使得RestTemplate具有负载均衡的效果
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
