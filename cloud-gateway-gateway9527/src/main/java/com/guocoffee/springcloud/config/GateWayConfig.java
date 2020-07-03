package com.guocoffee.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: springcloud
 * @description: 编程式配置Gateway路由
 * @author: guo-coffee
 * @create: 2020-07-03
 */
@Configuration
public class GateWayConfig {

    /**
     * localhost:9527/guonei 跳转到http://news.baidu.com/guonei
     * @param routeLocatorBuilder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_guocoffee",
                r -> r.path("/guonei")
                    .uri("http://news.baidu.com/guonei")).build();
        return routes.build();
    }

}
