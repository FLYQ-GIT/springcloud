package com.guocoffee.springcloud.dao;

import com.guocoffee.springcloud.entity.CommonResult;
import com.guocoffee.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @program: springcloud
 * @description:
 * @author: guo-coffee
 * @create: 2020-07-02
 */
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentDao {

    @GetMapping("/payment/get/{id}")
    CommonResult<Payment> getById(@PathVariable("id") long id);

}
