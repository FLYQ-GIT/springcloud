package com.guocoffee.springcloud.controller;

import com.guocoffee.springcloud.entity.CommonResult;
import com.guocoffee.springcloud.entity.Payment;
import com.guocoffee.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
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

    /**
     * 获取配置文件中的端口号
     */
    @Value("${server.port}")
    private String servicePort;

    @PostMapping("/save")
    public CommonResult save(@RequestBody Payment payment){
        log.info("执行保存操作--》输入～～～～" + payment);
        int i = paymentService.save(payment);
        log.info("执行保存操作～～～～" + i);
        log.info("执行保存操作～～～" + payment);
        if (i>0){
            return new CommonResult(200,"成功-->servicePort："+servicePort,i);
        }else {
            return new CommonResult(400,"失败-->servicePort："+servicePort);
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult get(@PathVariable("id")long id){
        Payment payment = paymentService.getById(id);
        log.info("执行查询操作～～～" + payment);
        if (payment != null){
            return new CommonResult(200,"成功-->servicePort："+servicePort,payment);
        }else {
            return new CommonResult(400,"失败-->servicePort："+servicePort);
        }
    }
}
