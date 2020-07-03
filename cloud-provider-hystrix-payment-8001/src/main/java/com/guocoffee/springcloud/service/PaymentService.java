package com.guocoffee.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

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

}
