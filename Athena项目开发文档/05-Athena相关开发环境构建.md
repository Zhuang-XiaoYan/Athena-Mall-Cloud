# Athena——系统基础环境部署设计

本博文主要是使用的KubeSphere来实现Kubernetes集群管理，以此更好的构建Athena系统中所设计到的基础的环境，
例如：nacos、mysql、redis、MQ、ES、等基础容器，同时为系统的管理和项目的部署提供的一个一站式的环境管理。
构建系统整体的架构设计与系统测试，CICD等。结合Github实现对code的质量的管理与控制。为系统在真实的互联网下的上线做好相关前置准备。

## KubeSphere容器平台构建

KubeSphere 愿景是打造一个以 Kubernetes 为内核的云原生分布式操作系统，
它的架构可以非常方便地使第三方应用与云原生生态组件进行即插即用（plug-and-play）的集成，
支持云原生应用在多云与多集群的统一分发和运维管理。

![img.png](images/KubeSphere.png)

### KubeSphere单节点的机器准备
```shell
# 机器最低要求：
 
8核 12G内存 100G的硬盘
 
# 机器系统：
 
centos7.4
 
# 防火墙放行 30000~32767
 
--开启防火墙
systemctl start firewalld
--重启防火墙
systemctl restart firewalld
--关闭防火墙
systemctl stop firewalld
--永久关闭防火墙（禁止开机自启动）
systemctl disable firewalld
--开启自启动防火墙
systemctl enable firewalld
--查看防火墙规则
firewall-cmd --list-all
--对指定IP放行指定端口（如果要取消，则将add替换为remove）
firewall-cmd --permanent --add-rich-rule="rule family="ipv4" source address="192.168.142.166" port protocol="tcp" port="30000" accept"
--对指定ip放行指定端口段
firewall-cmd --permanent --add-rich-rule="rule family="ipv4" source address="192.168.142.166" port protocol="tcp" port="30000-31000" accept"
--对指定ip放行所有端口
firewall-cmd --zone=public --add-rich-rule="rule family="ipv4" source address="192.168.1.10" accept" --permanent
--对所有ip放行指定端口
firewall-cmd --zone=public --add-port=10022/tcp --permanent 
--也可以直接编辑防火墙配置文件/etc/firewalld/zones/public.xml，保存后重启防火墙才生效

# 修改hostname 
hostnamectl set-hostname node_name
```

### KubeKey引导安装集群

```shell
安装 KubeKey
 
export KKZONE=cn
 
curl -sfL https://get-kk.kubesphere.io | VERSION=v1.2.1 sh -
 
# 安装相关依赖
 
yum install -y conntrack
 
# 使用kk 安装kubesphere
 
./kk create cluster --with-kubernetes v1.20.4 --with-kubesphere v3.1.1
```
![img.png](images/kubekeyintsall.png)

### KubeSphere系统测试

![img.png](images/kubeSpherecontroller.png)
![img.png](images/account_password.png)


## Athena系统基础镜像构建

由于个人资源有限，因此在构建整体系统采用的单节点构建KubeSphere容器平台。
在后期的项目真实的上线的时候可能多集群架构来实现的项目的安装与部署工作。同时后期本人将介绍相关的实战内容。

### Harobr仓库的部署构建


### Nacos部署k8s


### Mysql的部署


### Redis的部署


### MQ的部署


### Elasticsearch的部署


参考：

https://www.bookstack.cn/read/KubeSphere-3.2-zh/4295a21d28df7802-%E5%86%85%E7%BD%AE%E5%BA%94%E7%94%A8.md
https://zhuangxiaoyan.blog.csdn.net/article/details/122798232
https://zhuangxiaoyan.blog.csdn.net/article/details/122903393




