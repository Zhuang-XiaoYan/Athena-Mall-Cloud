# 指定基础镜像，本地没有会从dockerHub pull下来
FROM java:8

#作者
MAINTAINER zhaungxiaoyan
MAINTAINER mail:18279148786@163.com

# 把可执行jar包复制到基础镜像的根目录下
ADD athena-product.jar /athena-product.jar

# 镜像要暴露的端口，如要使用端口，在执行docker run命令时使用-p生效
EXPOSE 9006

# 在镜像运行为容器后执行的命令
ENTRYPOINT ["java","-jar","/athena-product.jar"]