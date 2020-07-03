package com.guocoffee.springcloud.loadblancer;


import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: springcloud
 * @description: 手写负载均衡算法
 * @author: guo-coffee
 * @create: 2020-07-03
 */
@Component
public class MyLoadBlancer implements LoadBlancer {

    /**
     * 定义一个原子引用类
     */
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(){
        int current;
        int next;

        do {
            current = this.atomicInteger.get();
            // 避免服务不重启，导致超出int最大值
            next = current >= Integer.MAX_VALUE ? 0 : current +1;

            // 使用cas算法，避免高并发时重复，不满足一直循环
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("*****第几次访问，次数next: "+next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size() ;
        return serviceInstances.get(index);
    }
}
