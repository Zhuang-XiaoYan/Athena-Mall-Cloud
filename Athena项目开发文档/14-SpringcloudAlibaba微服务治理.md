# SpringCloud的微服务治理

- 注册中心：SpringCloud Alibaba Nacos
- 配置中心：SpringCloud Alibaba Nacos
- 负载均衡：SpringCloud Ribbon
- 声明式HTTP客户端：SpringCloud Feign ——调用远程服务
- 负载均衡：SpringCloud Ribbon —— feign中已经整合，无需显示引用
- 服务容错：SpringCloud Alibaba Sentinel ——限流、降级、熔断
- API网关：SpringCloud Gateway ——webflux 编程模式
- 调用链路监控：SpringCloud Sleuth
- 分布式事务：SpringCloud Alibaba Seata ——原Fescar

## SpringCloud Alibaba Nacos的架构与原理

```shell
# docker的启动命令
docker run --name nacos -d -p 8848:8848 --privileged=true \
--restart=always \
-e JVM_XMS=512m \
-e JVM_XMX=2048m \
-e MODE=standalone \
-e PREFER_HOST_MODE=hostname \
-v /home/nacos/logs:/home/nacos/logs \
nacos/nacos-server:1.2.1
```

### 远程调用与服务发现

### 服务配置注册中心



## SpringCloud Ribbon的原理

## SpringCloud Feign的原理

## SpringCloud Alibaba Sentinel的原理

## SpringCloud Gateway的原理

## SpringCloud Sleuth的原理

## SpringCloud Alibaba Seata的原理