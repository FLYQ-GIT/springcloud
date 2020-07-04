package com.guocoffee.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @program: springcloud
 * @description:
 * @author: guo-coffee
 * @create: 2020-07-04
 */
@Component
@Slf4j
public class MyLogGateWayFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("***********come in MyLogGateWayFilter:  "+new Date());
        log.info("请求所有参数："+exchange.getRequest().getQueryParams());
        String username = exchange.getRequest().getQueryParams().getFirst("name");
        if (username == null){
            log.info("*******用户名为null，非法用户，o(╥﹏╥)o");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }

        // 若通过校验，则进行下一步操作
        return chain.filter(exchange);
    }

    /**
     * order 过滤器优先级
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
