package com.guocoffee.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springcloud
 * @description:
 * @author: guo-coffee
 * @create: 2020-07-02
 */
@RestController
@Slf4j
@RequestMapping("consulPayment")
public class PaymentController {
    /**
     * 获取配置文件中的端口号
     */
    @Value("${server.port}")
    private String servicePort;

    @GetMapping("/save")
    public String save(){
        return "访问端口：" + servicePort;
    }
}
