package com.guocoffee.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: springcloud
 * @description: openfeign日志级别配置
 * @author: guo-coffee
 * @create: 2020-07-03
 */
@Configuration
public class FeignConfig {

    @Bean
    Logger.Level feignLoggerLevel(){
        // 有4个级别 full是最细的
        return Logger.Level.FULL;
    }
}
