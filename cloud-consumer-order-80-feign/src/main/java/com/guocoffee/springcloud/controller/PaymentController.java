package com.guocoffee.springcloud.controller;

import com.guocoffee.springcloud.dao.PaymentDao;
import com.guocoffee.springcloud.entity.CommonResult;
import com.guocoffee.springcloud.entity.Payment;
import com.guocoffee.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: springcloud
 * @description:
 * @author: guo-coffee
 * @create: 2020-07-02
 */
@RestController
@Slf4j
@RequestMapping("/feignPayment")
public class PaymentController {

    @Resource
    PaymentService paymentService;

    /**
     * 获取配置文件中的端口号
     */
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/get/{id}")
    public CommonResult get(@PathVariable("id")long id){
        CommonResult<Payment> payment = paymentService.getById(id);
        log.info("执行查询操作～～～" + payment);
        return payment;
    }
}
