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

### Nacos在window下部署

Nacos文档:https://nacos.io/zh-cn/docs/deployment.html

Nacos1.4.0下载地址:https://github.com/alibaba/nacos/releases/tag/1.4.0

![img.png](../athena项目开发文档/images/nacos_download.png)

nacos1.4.0目录结构

![img.png](../athena项目开发文档/images/nacos_structure.png)

nacos1.4.0 Win10单机启动正确方式

```shell
# nacos1.4.0我这里启动的环境是jdk1.8.0_73,mysql数据库5.7以上就行。
# 因为如果直接在bin目录下用鼠标双击startup.cmd启动的话，默认的是以cluster(集群)的方式启动，
# 直接启动第一个会报db.num is null错误，解决完后在报Unable to start embedded Tomcat错误.

- 1.首先通过cmd进入到nacos文件夹里面bin目录
- 2.然后输入命令startup.cmd -m standalone 这里是将nacos以单机模式运行
```

![img.png](../athena项目开发文档/images/nacos_start_up.png)

如果启动看到如下，说明启动成功。

![img.png](../athena项目开发文档/images/nacos_standlone.png)

然后在浏览器输入网址:http://IP:8848/nacos/index.html#/login, 用户名和密码默认都是nacos

![img.png](../athena项目开发文档/images/nacos_login.png)

登录成功后是这个页面，到这里单机模式启动就结束了。

![img.png](../athena项目开发文档/images/nacos_admin.png)

### Nacos在dockerz中部署

```shell
# docker的启动命令
docker run -d -p 8848:8848 -e MODE=standalone \
-v /root/nacos/init.d/custom.properties:/home/nacos/init.d/custom.properties \
-v /root/nacos/logs:/home/nacos/logs \
--restart always \
--name nacos nacos/nacos-server
```

然后在浏览器输入网址:http://IP:8848/nacos/index.html#/login, 用户名和密码默认都是nacos

![img.png](../athena项目开发文档/images/nacos_login.png)

登录成功后是这个页面，到这里单机模式启动就结束了。

![img.png](../athena项目开发文档/images/nacos_admin.png)

### 远程调用与服务发现

```shell
#Spring service的属性
server:
  port: 11000
  servlet:
    session:
      timeout: 30m

# Spring的系列的属性
spring:
  # 配置Spring服务的名称
  application:
    name: athena-ware
  #配置Spring datebase的账户和连接
  datasource:
    username: root
    password: root
    url: jdbc:mysql://192.168.25.137:32081/athena_wms?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai
    driver-class-name: com.mysql.cj.jdbc.Driver
  # Springcloud alibaba nacos注册中心
  cloud:
    nacos:
      discovery:
        server-addr: 192.168.25.1:8848

# mybatis-plus的系列的属性
mybatis-plus:
  mapper-locations: classpath:/mapper/**/*.xml
  #设置实体类的自增主键
  global-config:
    db-config:
      id-type: auto
```

### 服务配置注册中心

给每一个服务建立自己的命令空间。同时每一个的命名空间设置对象的dev test online等
![img.png](../athena项目开发文档/images/nacos_service.png)
![img.png](../athena项目开发文档/images/nacos_config_online.png)
![img.png](../athena项目开发文档/images/Athena微服务配置.png)
![img.png](../athena项目开发文档/images/nacos_discovery.png)

## SpringCloud Ribbon的原理

## SpringCloud Ribbon的使用

## SpringCloud Feign的原理

## SpringCloud Feign的使用

## SpringCloud Gateway的原理

### SpringCloud Gateway的使用

### SpringCloud Gateway的在athena系统中的设计架构

## SpringCloud Sleuth的原理

## SpringCloud Alibaba Seata的原理

## SpringCloud Alibaba Sentinel的原理
