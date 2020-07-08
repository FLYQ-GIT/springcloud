package com.guocoffee.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @program: springcloud
 * @description:
 * @author: guo-coffee
 * @create: 2020-07-08
 */
@Configuration
@MapperScan("com.guocoffee.springcloud.dao")
public class MybatisConfig {
}
