package com.guocoffee.springcloud.controller;

import com.guocoffee.springcloud.entity.CommonResult;
import com.guocoffee.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @program: springcloud
 * @description:
 * @author: guo-coffee
 * @create: 2020-07-02
 */
@RestController
@Slf4j
@RequestMapping("/consulOrder")
public class OrderController {

    private static final String URL = "http://CONSUL-PROVIDER-PAYMENT";

    @Resource
    RestTemplate restTemplate;

    @GetMapping("/save")
    public String getById(){
        String str = restTemplate.getForObject(URL + "/consulPayment/save", String.class);
        log.info("OrderController-->get==>"+str);
        return str;
    }
}
