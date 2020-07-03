package com.guocoffee.springcloud.service;

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
     * @param id
     * @return
     */
    public String paymentInfoTimeout(long id){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池： " + Thread.currentThread().getName() +"\t"+ "paymentInfoTimeout(),id:"+ id+ "\t" +" \"O(∩_∩) 成功返回哈哈哈";
    }
}
