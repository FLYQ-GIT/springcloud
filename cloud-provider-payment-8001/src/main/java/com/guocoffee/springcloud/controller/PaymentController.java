package com.guocoffee.springcloud.controller;

import com.guocoffee.springcloud.entity.CommonResult;
import com.guocoffee.springcloud.entity.Payment;
import com.guocoffee.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @program: springcloud
 * @description:
 * @author: guo-coffee
 * @create: 2020-07-02
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    PaymentService paymentService;

    @PostMapping("/save")
    public CommonResult save(@RequestBody Payment payment){
        log.info("执行保存操作--》输入～～～～" + payment);
        int i = paymentService.save(payment);
        log.info("执行保存操作～～～～" + i);
        log.info("执行保存操作～～～" + payment);
        if (i>0){
            return new CommonResult(200,"成功",i);
        }else {
            return new CommonResult(400,"失败");
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult get(@PathVariable("id")long id){
        Payment payment = paymentService.getById(id);
        log.info("执行查询操作～～～" + payment);
        if (payment != null){
            return new CommonResult(200,"成功～～～",payment);
        }else {
            return new CommonResult(400,"失败～～～");
        }
    }
}
