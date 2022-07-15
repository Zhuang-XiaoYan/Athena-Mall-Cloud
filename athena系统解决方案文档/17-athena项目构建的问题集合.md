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

> Linux虚拟机（lvm）报Unmount and run xfs_repair
> ![img.png](images/服务器断电问题.png)
> 原因：因为突然断电，导致机器关闭 导致sda3分区损坏，修复就可以了。
> 结果：发现有一台虚拟机无法启动，一直报错 Unmount and run xfs_repair 
> 分析：主机异常掉电后里面的虚拟机无法启动，主要是损坏的分区

解决办法：

1. 启动虚拟机的时候，摁E键进入单用户模式。
![img.png](images/单用户模式.png)

2. 找到linux16 这一行(在fi下一行) 的最后，添加：rd.break ，然后在ctrl+x进入救援模式
![img.png](images/breadk命令.png)

3. 执行：umount /dev/sda3 ，然后在执行：xfs_repair -L /dev/sda3

4. 等待分区修复后，则输入(关闭命令)：init 0

5. 再重启虚拟机即可







