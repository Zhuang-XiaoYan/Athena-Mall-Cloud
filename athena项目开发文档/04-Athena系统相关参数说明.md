# Athena系统相关参数说明

## 项目的软件依赖版本
```shell
#Springboot的版本

<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.1.8.RELEASE</version>
    <relativePath/> <!-- lookup parent from repository -->
</parent>

<java.version>1.8</java.version>
<spring-cloud.version>Greenwich.SR3</spring-cloud.version>

# 依赖的版本管理

<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-dependencies</artifactId>
            <version>${spring-cloud.version}</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>

        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-alibaba-dependencies</artifactId>
            <version>2.1.0.RELEASE</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>

```






## 项目相关参数
- QPS指标
- TPS指标
- mysql的数据量
- redis的集群数量
- mysql的集群数量
- nginx的数量
- MQ集群的数量
- ES集群的数量
- Nacos集群的数量
- 微服务的数量



博文参考
**springcloud与nacos的需要的版本的适配问题**
- https://www.cnblogs.com/joshua317/p/15302934.html