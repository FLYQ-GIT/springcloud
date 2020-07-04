package com.guocoffee.springcloud.service.controller;

import com.guocoffee.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: springcloud
 * @description:
 * @author: guo-coffee
 * @create: 2020-07-04
 */
@RestController
public class MessageProviderCtr {

    @Resource
    IMessageProvider iMessageProvider;

    /**
     *
     * @return
     */
    @RequestMapping("messageSend")
    public String messageSend(){
        return iMessageProvider.send();
    }

}
