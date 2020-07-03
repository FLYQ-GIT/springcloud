package com.guocoffee.springcloud.controller;

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
import java.util.concurrent.TimeUnit;

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
    private String serverPort;

    /**
     * 通过服务发现获取信息
     */
    @Resource
    DiscoveryClient discoveryClient;

    @PostMapping("/save")
    public CommonResult save(@RequestBody Payment payment){
        log.info("执行保存操作--》输入～～～～" + payment);
        int i = paymentService.save(payment);
        log.info("执行保存操作～～～～" + i);
        log.info("执行保存操作～～～" + payment);
        if (i>0){
            return new CommonResult(200,"成功-->servicePort："+ serverPort,i);
        }else {
            return new CommonResult(400,"失败-->servicePort："+ serverPort);
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult get(@PathVariable("id")long id){
        Payment payment = paymentService.getById(id);
        log.info("执行查询操作～～～" + payment);
        if (payment != null){
            return new CommonResult(200,"成功～～～-->servicePort："+ serverPort,payment);
        }else {
            return new CommonResult(400,"失败～～～-->servicePort："+ serverPort);
        }
    }

    @GetMapping("/getClient")
    public Object getClient(){
        // 查询eureka中注册的所有微服务
        List<String> services = discoveryClient.getServices();
        log.info("所有的注册的所有微服务～～～");
        for (String s : services) {
            log.info(s);
        }

        // 根据微服务的具体名称获取当前微服务下所有的实例
        log.info("CLOUD-PAYMENT-SERVICE实例～～～");
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance i:instances) {
            log.info("注册ID："+i.getInstanceId()+"，地址："+i.getHost()+"，端口："+i.getPort()+","+i.getUri());
        }

        return discoveryClient;
    }

    /**
     * 测试超时服务
     * @return
     */
    @GetMapping("/timeout")
    public String timeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
