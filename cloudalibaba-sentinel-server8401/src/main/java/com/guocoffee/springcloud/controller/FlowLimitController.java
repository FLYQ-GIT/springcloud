package com.guocoffee.springcloud.controller;

import ch.qos.logback.core.util.TimeUtil;
import cn.hutool.core.thread.ThreadUtil;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @program: springcloud
 * @description:
 * @author: guo-coffee
 * @create: 2020-07-06
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB(){
        log.info(Thread.currentThread().getName()+"\t"+"...testB");

        // rt：每秒请求树大于5时，且返回时间大于200毫秒，则会在时间窗口期之内不能访问，返回：Blocked by Sentinel (flow limiting)
        log.info("测试服务降级-->rt");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 异常比例：每秒请求树大于5时，且失败概率大于20%，则会在时间窗口期之内不能访问，返回：Blocked by Sentinel (flow limiting)
//        log.info("测试服务降级-->异常比例");
//        int a = 10/0;

        // 注意：时间窗口期要大于等于60秒
        // 异常数：在一分钟内，异常数达到【异常数】配置值后，则会在时间窗口期之内不能访问，返回：Blocked by Sentinel (flow limiting)
        log.info("测试服务降级-->异常比例");
        int a = 10/0;

        return "------testB";
    }

    /**
     * SentinelResource注解相当于HystrixCommand
     * 配合blockHandler使用，否则会报error page页面
     *
     * @SentinelResource(value = "hotKey",blockHandler = "block_hotKey")
     * 资源名为hotKey，与Sentinel后台配置资源名一致
     * blockHandler为不满足配置条件时需要执行的方法，参数多一个BlockException
     *
     * 测试：
     * 配置参数索引为0，所以只会监控第一个参数
     * http://localhost:8401/hotKey?name=10 不会触发熔断
     * http://localhost:8401/hotKey?name=10&id=1 若带有id参数则会触发熔断
     *
     * 新加默认值：defaultValue = "10"
     * http://localhost:8401/hotKey?name=haha 存在默认值也会触发熔断
     *
     *
     * 配置参数例外项：
     * 例如配置了类型string 参数值 5 阈值100，标示id为5的阈值可以达到100，其他的按照默认
     *
     * @param id
     * @param name
     * @return
     */
    @RequestMapping("/hotKey")
    @SentinelResource(value = "hotKey",blockHandler = "block_hotKey")
    public String hotKey(@RequestParam(value = "id",required = false,defaultValue = "10")String id,@RequestParam(value = "name",required = false)String name){
        return "hotKey~~~~id:"+id+"~~~name:"+name;
    }

    public String block_hotKey(String id, String name, BlockException ex){
        ex.printStackTrace();
        return "block_hotKey~~~~id:"+id+"~~~name:"+name;
    }
}
