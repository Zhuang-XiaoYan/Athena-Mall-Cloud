package com.zhuangxiaoyan.athena.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rabbitmq.client.Channel;
import com.zhuangxiaoyan.athena.order.dao.OrderItemDao;
import com.zhuangxiaoyan.athena.order.entity.OrderEntity;
import com.zhuangxiaoyan.athena.order.entity.OrderItemEntity;
import com.zhuangxiaoyan.athena.order.service.OrderItemService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.Query;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @description OrderItemServiceImpl
 * @date: 2022/7/30 23:39
 * @author: xjl
 */
@RabbitListener(queues = {"athena-queue"})
@Service("orderItemService")
public class OrderItemServiceImpl extends ServiceImpl<OrderItemDao, OrderItemEntity> implements OrderItemService {

    /**
     * @description 查询
     * @param: params
     * @date: 2022/7/30 23:44
     * @return: com.zhuangxiaoyan.common.utils.PageUtils
     * @author: xjl
     */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OrderItemEntity> page = this.page(new Query<OrderItemEntity>().getPage(params), new QueryWrapper<OrderItemEntity>());
        return new PageUtils(page);
    }

    /**
     * @description 监听的队列中的消息
     * @param: message  消息的类型的非常的详细
     * @param: OrderEntity orderEntity 接收的消息的类型
     * @param: Channel channel mq的通道
     * Queues 可以有很多人来监听， 队列删除的消息 而且只有一个收到的消息
     * @date: 2022/9/4 18:48
     * @return: void
     * @author: xjl
     */
    @RabbitHandler
    public void receiveMessage(Message message, OrderEntity orderEntity, Channel channel) {
        System.out.println(message.getBody() + "------" + message.getMessageProperties());
        System.out.println("具体的类容是：" + orderEntity);
    }
}