package com.guocoffee.springcloud.service;

import com.guocoffee.springcloud.entity.CommonResult;
import com.guocoffee.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @program: springcloud
 * @description:
 * @author: guo-coffee
 * @create: 2020-07-02
 */
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentFallbackService.class)
public interface PaymentService {

    @GetMapping("/hystrix/ok/{id}")
    String paymentInfoOk(@PathVariable("id") long id);

    @GetMapping("/hystrix/timeout/{id}")
    String paymentInfoTimeOut(@PathVariable("id") long id);
}
