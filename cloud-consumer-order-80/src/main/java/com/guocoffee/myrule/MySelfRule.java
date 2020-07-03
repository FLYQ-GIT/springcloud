package com.guocoffee.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: springcloud
 * @description: ribbon负载均衡配置
 * @author: guo-coffee
 * @create: 2020-07-03
 */
@Configuration
public class MySelfRule {

    /**
     * ribbon官方标注不可以放在@ComponentScan扫描包下,放在该扫描包下，达不到特殊化配置，会使得所有ribbon客户端都共享
     * @SpringBootApplication中包含了@ComponentScan，标示主方法在的文件及以下均会被扫描到
     * 所以自定义ribbon负载均衡配置新建文件配置
     * 默认使用轮询
     */

    /**
     * 使用随机
     * @return
     */
    @Bean
    public IRule myRule(){   //定义为随机
//        new RoundRobinRule(); 默认轮询，若使用轮询可不操作
//        new RetryRule();  先按照轮询的策略获取服务，若失败则会在指定时间内重试，然后再获取可用服务
        //定义为随机
        return new RandomRule();
    }
}
