package com.guocoffee.springcloud.service;

import com.guocoffee.springcloud.entity.Order;
import org.springframework.stereotype.Service;

public interface IOrderService {

    void create(Order order);
}
