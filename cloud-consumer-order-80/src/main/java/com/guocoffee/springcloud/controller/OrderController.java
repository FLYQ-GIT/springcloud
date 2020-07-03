package com.guocoffee.springcloud.controller;

import com.guocoffee.springcloud.entity.CommonResult;
import com.guocoffee.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/order")
public class OrderController {

//    private static final String URL = "http://localhost:8001";
    private static final String URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    RestTemplate restTemplate;

    @PostMapping("/save")
    public CommonResult save(Payment payment){
        log.info("OrderController-->save-->输入==>"+payment);
        CommonResult commonResult = restTemplate.postForObject(URL + "/payment/save", payment, CommonResult.class);
        log.info("OrderController-->save==>"+commonResult);
        return commonResult;
    }

    @GetMapping("/get/{id}")
    public CommonResult getById(@PathVariable("id")long id){
        CommonResult commonResult = restTemplate.getForObject(URL + "/payment/get/"+id, CommonResult.class);
        log.info("OrderController-->get==>"+commonResult);
        return commonResult;
    }

    @GetMapping("/getForEntity/{id}")
    public CommonResult getForEntity(@PathVariable("id")long id){
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(URL + "/payment/get/" + id, CommonResult.class);
        log.info("OrderController-->get==>"+entity);
        if (entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else {
            return new CommonResult(400,"失败～～～");
        }
    }
}
