package com.guocoffee.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import com.guocoffee.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

/**
 * @program: springcloud
 * @description:
 * @author: guo-coffee
 * @create: 2020-07-04
 */
@EnableBinding(Source.class) // 定义生产者的推送管道
@Slf4j
public class MessageProviderImpl implements IMessageProvider {

    /**
     * 消息发送管道
     */
    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String s = IdUtil.simpleUUID().toString();
        output.send(MessageBuilder.withPayload(s).build());
        log.info("发送信息："+s);
        return s;
    }
}
