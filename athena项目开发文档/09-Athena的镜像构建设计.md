# Athena 镜像构建设计

## Springboot的Dockerfile构建

- 下面的是基本的dockerfile的构建文件，下面是的一个构建Springboot的服务镜像

```shell
# 指定基础镜像，本地没有会从dockerHub pull下来
FROM java:8

#作者
MAINTAINER zhaungxiaoyan
MAINTAINER mail:18279148786@163.com

# 把可执行jar包复制到基础镜像的根目录下
ADD athena-ware.jar /athena-ware.jar

# 镜像要暴露的端口，如要使用端口，在执行docker run命令时使用-p生效
EXPOSE 11000

# 在镜像运行为容器后执行的命令
ENTRYPOINT ["java","-jar","/athena-ware.jar"]

```

- 构建Springboot服务的命令

```shell
docker build -t Athena/athena-ware:V0.1 .
# -f指定Dockerfile文件的路径
# -t指定镜像名字和TAG
# .指当前目录，这里实际上需要一个上下文路径
```

- 运行自己的SpringBoot镜像

```shell
docker run --name athena-ware -p 11000:11000 -d Athena/athena-ware:V0.1
```

## python服务的Dockerfile构建

# Athena 镜像上传到仓库管理

## Athena 镜像仓库的构建

## Athena 镜像仓库的管理

## Athena 镜像仓库上传

# 参考资料

- https://yeasy.gitbook.io/docker_practice/image/dockerfile
- 
