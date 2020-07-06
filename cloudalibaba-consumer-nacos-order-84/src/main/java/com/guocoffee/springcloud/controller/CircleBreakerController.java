package com.guocoffee.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.guocoffee.springcloud.entity.CommonResult;
import com.guocoffee.springcloud.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @program: springcloud
 * @description:
 * @author: guo-coffee
 * @create: 2020-07-06
 */
@RestController
public class CircleBreakerController {

//    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Value("${service-url.nacos-user-service}")
    private String SERVICE_URL;

    @Resource
    private RestTemplate restTemplate;

    /**
     * fallback只负责业务异常
     * blockHandler只负责sentinel控制台配置违规
     * @param id
     * @return
     */
    @RequestMapping("/consumer/fallback/{id}")
//    @SentinelResource(value = "fallback") //没有配置,报错时显示error page，错误不应该抛给调用端处理
//    @SentinelResource(value = "fallback",fallback = "handlerFallback") //fallback只负责业务异常，出现异常时，执行fallback方法，保证不会抛出错误
//    @SentinelResource(value = "fallback",blockHandler = "blockHandler") //blockHandler只负责sentinel控制台配置违规
//    @SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "blockHandler") //fallback和blockHandler同时配置，先执行限流，再执行方法
    //  //排除异常：exceptionsToIgnore，若程序出现IllegalArgumentException错误，则不会进入fallback
    @SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "blockHandler",exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResult<Payment> fallback(@PathVariable Long id){
        CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/"+id, CommonResult.class,id);

        if (id == 4) {
            throw new IllegalArgumentException ("IllegalArgumentException,非法参数异常....");
        }else if (result.getData() == null) {
            throw new NullPointerException ("NullPointerException,该ID没有对应记录,空指针异常");
        }

        return result;
    }

    /**
     * fallback，运行异常
     * @param id
     * @param e
     * @return
     */
    public CommonResult handlerFallback(@PathVariable Long id, Throwable e) {
        Payment payment = new Payment(id,"null");
        return new CommonResult<>(400,"兜底异常handlerFallback,exception内容  "+e.getMessage(),payment);
    }

    /**
     * lockHandler，sentinel控制台配置违规
     * @param id
     * @param blockException
     * @return
     */
    public CommonResult blockHandler(@PathVariable  Long id, BlockException blockException) {
        Payment payment = new Payment(id,"null");
        return new CommonResult<>(400,"blockHandler-sentinel限流,无此流水: blockException  "+blockException.getMessage(),payment);
    }

}
