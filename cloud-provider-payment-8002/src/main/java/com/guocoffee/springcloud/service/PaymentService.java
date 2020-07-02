package com.guocoffee.springcloud.service;

import com.guocoffee.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * @program: springcloud
 * @description:
 * @author: guo-coffee
 * @create: 2020-07-02
 */
@Service
public interface PaymentService {

    Payment getById(@Param("id") long id);

    int save(Payment payment);
}
