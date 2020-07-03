package com.guocoffee.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @program: springcloud
 * @description:
 * @author: guo-coffee
 * @create: 2020-07-03
 */
@Service
public class PaymentService {

    /**
     * 正常返回
     * @param id
     * @return
     */
    public String paymentInfoOK(long id){
        return "线程池： " + Thread.currentThread().getName() +"\t"+ "paymentInfoOK(),id:"+ id+ "\t" +" \"O(∩_∩) 成功返回哈哈哈";
    }

    /**
     * 模拟超时业务
     * 超时3秒之后调用paymentInfoTimeoutHandler方法
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler",
            commandProperties = {@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000")})
    public String paymentInfoTimeout(long id){
        // 测试报错Hystrix服务降级
//        int a = 1/0;

        // 测试超时Hystrix服务降级
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "线程池： " + Thread.currentThread().getName() +"\t"+ "paymentInfoTimeout(),id:"+ id+ "\t" +" \"O(∩_∩) 成功返回哈哈哈";
    }

    public String paymentInfoTimeoutHandler(long id){
        return "线程池： " + Thread.currentThread().getName() +"\t"+ "paymentInfoTimeoutHandler(),id:"+ id+ "\t" +" \"超时兜底";
    }


    //==================以下为服务熔断=================


    /**
     * fallbackMethod 服务异常后执行的方法
     * 开启断路器标示：在时间窗口期（10秒）内，请求10次中，存在60%的失败率就会跳闸
     * HystrixCommandProperties类中可以查看一些基础配置信息
     *
     * 先降级-->再熔断-->恢复线路
     *
     * 实验结果：多次输入负数，导致熔断，然后再输入正树，发现返回的依旧是错误信息，稍等一会儿之后再访问就正常了
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器（开启）
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),// 请求次数（10次）
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期（10秒）
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),// 失败率达到多少后跳闸（60%）
    })
    public String paymentCircuitBreaker( Integer id) {

        if (id<0){
            throw new RuntimeException("******id 不能负数");
        }
        // hutool工具类，相当于UUID.randomUUID().toString()
        String str = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功，流水号: " + str;
    }

    public String paymentCircuitBreaker_fallback(Integer id){
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " +id;
    }

}
