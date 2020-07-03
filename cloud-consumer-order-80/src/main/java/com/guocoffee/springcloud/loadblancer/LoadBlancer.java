package com.guocoffee.springcloud.loadblancer;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @program:
 * @description: 手写负载均衡算法，面向接口开发，子类实现对应方法
 * @author: guo-coffee
 * @create: 2020-07-02
 */
public interface LoadBlancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
