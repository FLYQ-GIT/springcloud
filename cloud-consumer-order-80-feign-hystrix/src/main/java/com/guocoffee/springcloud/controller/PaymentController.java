package com.guocoffee.springcloud.controller;

import com.guocoffee.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
@DefaultProperties(defaultFallback = "errorGlobalHandler")
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
     * 加上HystrixCommand注解，标示需要降级处理
     * 若配置了fallbackMethod等明细，则按照配置的处理
     * 若没有，则走默认配置
     *
     * @return
     */
    @GetMapping("/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "timeoutHandler",
//            commandProperties = {@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="2000")})
    @HystrixCommand
    public String timeout(@PathVariable("id")long id){
//        int a = 1/0;
        String s = paymentService.paymentInfoTimeOut(id);
        return s;
    }

    public String timeoutHandler(long id){
        return "feignHystrixPayment客户端自己兜底，超时2秒返回";
    }

    public String errorGlobalHandler(){
        return "全局Hystrix，统一降级方法处理～～～";
    }

}
