# Athena项目开发中的问题

> 解决IDEA 2020.3 lombok失效问题
> 
> 本地安装的是IDEA2020.3 社区版，使用lombok插件失效，编译报错，
> “You aren‘t using a compiler supported by lombok, so lombok will not work and has been disabled.”

解决方案一：

在以下位置加上该配置"-Djps.track.ap.dependencies=false"

![img.png](images/lombok失效问题.png)

解决方案二：

升级 lombok 的版本至 1.18.14+及以上。






