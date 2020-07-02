package com.guocoffee.springcloud.service.impl;

import com.guocoffee.springcloud.dao.PaymentDao;
import com.guocoffee.springcloud.entity.Payment;
import com.guocoffee.springcloud.service.PaymentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: springcloud
 * @description:
 * @author: guo-coffee
 * @create: 2020-07-02
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    PaymentDao paymentDao;

    @Override
    public Payment getById(long id){
        return paymentDao.getById(id);
    }

    @Override
    public int save(Payment payment){
        return paymentDao.save(payment);
    }
}
