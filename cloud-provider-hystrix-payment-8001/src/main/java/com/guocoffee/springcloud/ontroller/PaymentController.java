package com.guocoffee.springcloud.ontroller;

import com.guocoffee.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @program: springcloud
 * @description:
 * @author: guo-coffee
 * @create: 2020-07-03
 */
@RestController
@Slf4j
@RequestMapping("/hystrix")
public class PaymentController {

    @Resource
    PaymentService paymentService;

    @GetMapping("/ok/{id}")
    public String paymentInfoOk(@PathVariable("id") long id){
        String result = paymentService.paymentInfoOK(id);
        log.info("----result-------："+ result);
        return result;
    }

    @GetMapping("/timeout/{id}")
    public String paymentInfoTimeOut(@PathVariable("id") long id){
        String result = paymentService.paymentInfoTimeout(id);
        log.info("----result-------："+ result);
        return result;
    }


    //==================以下为服务熔断=================


    @GetMapping("/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id)
    {
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("****result: "+result);
        return result;
    }

}
