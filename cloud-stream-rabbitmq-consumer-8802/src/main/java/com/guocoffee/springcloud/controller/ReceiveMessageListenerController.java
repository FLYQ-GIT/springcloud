package com.guocoffee.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Controller;

/**
 * @program: springcloud
 * @description:
 * @author: guo-coffee
 * @create: 2020-07-04
 */
@Controller
@EnableBinding(Sink.class) // 绑定消费者的推送管道
@Slf4j
public class ReceiveMessageListenerController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        log.info("消费者【"+serverPort+"】消费信息：" + message.getPayload());
    }
}
