package com.guocoffee.springcloud.controller;

import com.guocoffee.springcloud.entity.CommonResult;
import com.guocoffee.springcloud.entity.Payment;
import com.guocoffee.springcloud.loadblancer.LoadBlancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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
@RequestMapping("/order")
public class OrderController {

//    private static final String URL = "http://localhost:8001";
    private static final String URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    RestTemplate restTemplate;
    /**
     * 注入自己写的负载均衡算法
     */
    @Resource
    LoadBlancer loadBlancer;
    /**
     * 通过服务发现获取信息
     */
    @Resource
    DiscoveryClient discoveryClient;

    /**
     * 测试post
     * @param payment
     * @return
     */
    @PostMapping("/save")
    public CommonResult save(Payment payment){
        log.info("OrderController-->save-->输入==>"+payment);
        CommonResult commonResult = restTemplate.postForObject(URL + "/payment/save", payment, CommonResult.class);
        log.info("OrderController-->save==>"+commonResult);
        return commonResult;
    }

    /**
     * 测试get
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public CommonResult getById(@PathVariable("id")long id){
        CommonResult commonResult = restTemplate.getForObject(URL + "/payment/get/"+id, CommonResult.class);
        log.info("OrderController-->get==>"+commonResult);
        return commonResult;
    }

    /**
     * 测试getForEntity
     * @param id
     * @return
     */
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

    /**
     * 测试自己手写的负载均衡
     * @param id
     * @return
     */
    @GetMapping("/myLB/{id}")
    public CommonResult myLB(@PathVariable("id")long id){

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() <= 0){
            return new CommonResult(400,"无可用服务");
        }
        ServiceInstance i = loadBlancer.instances(instances);
        log.info("注册ID："+i.getInstanceId()+"，地址："+i.getHost()+"，端口："+i.getPort()+","+i.getUri());

        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(i.getUri() + "/payment/get/" + id, CommonResult.class);
        log.info("OrderController-->get==>"+entity);
        if (entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else {
            return new CommonResult(400,"失败～～～");
        }
    }


    /**
     * 测试sleuth+zipkin链路监控
     * @return
     */
    @GetMapping("/zipkin")
    public String paymentZipkin(){
        String str = restTemplate.getForObject(URL + "/payment/zipkin", String.class);
        return str;
    }
}
