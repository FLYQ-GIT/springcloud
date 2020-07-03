package com.guocoffee.springcloud.controller;

import com.guocoffee.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: springcloud
 * @description:
 * @author: guo-coffee
 * @create: 2020-07-02
 */
@RestController
@Slf4j
@RequestMapping("/feignHystrixPayment")
public class PaymentController {

    @Resource
    PaymentService paymentService;

    /**
     * 获取配置文件中的端口号
     */
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/get/{id}")
    public String get(@PathVariable("id")long id){
        String s = paymentService.paymentInfoOk(id);
        return s;
    }

    /**
     * 测试超时
     * @return
     */
    @GetMapping("/timeout/{id}")
    public String timeout(@PathVariable("id")long id){
        String s = paymentService.paymentInfoTimeOut(id);
        return s;
    }
}
