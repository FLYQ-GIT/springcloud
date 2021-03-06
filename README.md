# springcloud
主要用于个测试springcloud简易微服务

### 包说明
cloud-api-commons 工程优化，抽离相同的类

使用eureka做服务注册发现、ribbon负载均衡
cloud-consumer-order-80 消费者
cloud-eureka-server-7001 eureka服务端
cloud-eureka-server-7002 eureka服务端
cloud-provider-payment-8001 eureka客户端
cloud-provider-payment-8002 eureka客户端

使用zookeeper做注册中心，目前存在异常
cloud-provider-payment-8004

简单版consul做服务注册服务发现
cloud-consumer-order-80-consul
cloud-provider-payment-8007

**eureka、zookeeper、consul区别**
- eureka 语言：Java、cap:ap保证高可用、服务健康检查：可配支持、对外暴露接口：http（可以通过网页访问）
- zookeeper 语言：go、cap:cp保证数据一致性、服务健康检查：支持、对外暴露接口：Linux客户端
- consul 语言：go、cap:cp保证数据一致性、服务健康检查：支持、对外暴露接口：http（可以通过网页访问）

使用openfeignfeign做远程调用
cloud-consumer-order-80-feign
配合7001、7002、8001、8002使用

hystrix降级熔断
cloud-provider-hystrix-payment-8001
cloud-consumer-order-80-feign-hystrix
配合7001、7002

hystrix图形化监控
cloud-consumer-hystrix-dashboard-9001

gateway路由
cloud-gateway-gateway9527
三大核心：路由/断言/过滤

sleuth+zipkin链路测试
http://192.168.0.130:9411/zipkin


http://192.168.0.130:8848/nacos/
-DServer.port=9011