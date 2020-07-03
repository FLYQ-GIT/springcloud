package com.guocoffee.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @program: springcloud
 * @description:
 * @author: guo-coffee
 * @create: 2020-07-03
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public String paymentInfoOk(long id) {
        return "PaymentFallbackService~~~paymentInfoOk～～～feign远程调用服务降级--》客户端方法";
    }

    @Override
    public String paymentInfoTimeOut(long id) {
        return "PaymentFallbackService~~~paymentInfoTimeOut～～～feign远程调用服务降级--》客户端方法";
    }
}
