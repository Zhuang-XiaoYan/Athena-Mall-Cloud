package com.zhuangxiaoyan.athena.order.mq;

import com.zhuangxiaoyan.athena.order.entity.OrderEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @Classname RabbitMqTest
 * @Description TODO
 * @Date 2022/9/4 16:16
 * @Created by xjl
 */

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqTest {

    @Autowired
    AmqpAdmin amqpAdmin;

    @Autowired
    RabbitTemplate rabbitTemplate;

    /**
     * @description 创建交换机的测试
     * @param:
     * @date: 2022/9/4 16:17
     * @return: void
     * @author: xjl
     */
    @Test
    public void createExchange() {
        // 创建的成为一个交换机
        DirectExchange directExchange = new DirectExchange("athena-exchange", true, false);
        amqpAdmin.declareExchange(directExchange);
        System.out.println("交换机创建完成…………" + directExchange.getName());
    }

    /**
     * @description 创建一个的队列
     * @param:
     * @date: 2022/9/4 17:01
     * @return: void
     * @author: xjl
     */
    @Test
    public void createQueues() {
        // 创建的成为一个队列
        // Queue(String name, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments)
        Queue athequeue = new Queue("athena-queue", true, false, false);
        amqpAdmin.declareQueue(athequeue);
        System.out.println("队列创建完成…………" + athequeue.getName());
    }

    /**
     * @description 创建一个的binding的关系
     * @param:
     * @date: 2022/9/4 17:01
     * @return: void
     * @author: xjl
     */
    @Test
    public void createBinding() {
        // 构建一个绑定关系
        // Binding(String destination, Binding.DestinationType destinationType, String exchange, String routingKey, Map<String, Object> arguments)
        Binding binding = new Binding("athena-queue", Binding.DestinationType.QUEUE, "athena-exchange", "hello.java", null);
        amqpAdmin.declareBinding(binding);
        System.out.println("构建一个绑定关系完成…………");
    }

    /**
     * @description 测试向mq中的交换机发送消息
     * @param:
     * @date: 2022/9/4 17:02
     * @return: void
     * @author: xjl
     */
    @Test
    public void sendMessageJDKTest() {
        // 向mq中发送的消息
        rabbitTemplate.convertAndSend("athena-exchange", "hello.java", "Hello world!!");
        System.out.println("消息发送成功…………");
    }

    /**
     * @description 测试向mq中的交换机发送消息json的格式化方式
     * @param:
     * @date: 2022/9/4 17:02
     * @return: void
     * @author: xjl
     */
    @Test
    public void sendMessageJSONTest() {
        // 向mq中发送的消息
        String exchange = "athena-exchange";
        String routingKey = "hello.java";
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setCommentTime(new Date());
        orderEntity.setBillContent("athena test");
        rabbitTemplate.convertAndSend(exchange, routingKey, orderEntity);
        System.out.println("消息发送成功…………");
    }

    /**
     * @description 获取队列中的消息的方式
     * @param:
     * @date: 2022/9/4 17:02
     * @return: void
     * @author: xjl
     */
    @Test
    public void accpectMessageest() {
        OrderEntity orderEntity = (OrderEntity) rabbitTemplate.receiveAndConvert("athena-queue");
        System.out.println(orderEntity.toString());
    }
}
