package com.guocoffee.springcloud.service;

import com.guocoffee.springcloud.entity.CommonResult;
import com.guocoffee.springcloud.entity.Payment;
import org.springframework.stereotype.Service;

/**
 * @program: springcloud
 * @description:
 * @author: guo-coffee
 * @create: 2020-07-02
 */
public interface PaymentService {

    CommonResult<Payment> getById(long id);

}
