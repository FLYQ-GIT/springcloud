package com.guocoffee.springcloud.service.impl;

import com.guocoffee.springcloud.entity.CommonResult;
import com.guocoffee.springcloud.entity.Payment;
import com.guocoffee.springcloud.service.IPaymentService;
import org.springframework.stereotype.Component;

/**
 * @program: springcloud
 * @description:
 * @author: guo-coffee
 * @create: 2020-07-06
 */
@Component
public class PaymentFallbackService implements IPaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(400,"服务降级返回,---PaymentFallbackService",new Payment(id,"errorSerial"));
    }
}
