package com.zhuangxiaoyan.athena.ware.config;

import com.google.common.collect.Maps;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

/**
 * @description mq的配置
  * @param: null
 * @date: 2022/9/13 9:13
 * @return:
 * @author: xjl
*/

@Configuration
public class RabbitMqConfig {

    /**
     * @description 使用JSON序列化机制，进行消息转换
      * @param:
     * @date: 2022/9/13 9:17
     * @return: org.springframework.amqp.support.converter.MessageConverter
     * @author: xjl
    */
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    /**
     * @description 库存服务默认的交换机
      * @param:
     * @date: 2022/9/13 9:17
     * @return: org.springframework.amqp.core.Exchange
     * @author: xjl
    */
    @Bean
    public Exchange stockEventExchange() {
        TopicExchange topicExchange = new TopicExchange("stock-event-exchange", true, false);
        return topicExchange;
    }

    /**
     * @description 普通队列
      * @param:
     * @date: 2022/9/13 9:17
     * @return: org.springframework.amqp.core.Queue
     * @author: xjl
    */
    @Bean
    public Queue stockReleaseStockQueue() {
        Queue queue = new Queue("stock.release.stock.queue", true, false, false);
        return queue;
    }

    /**
     * @description 延迟队列
      * @param:
     * @date: 2022/9/13 9:16
     * @return: org.springframework.amqp.core.Queue
     * @author: xjl
    */
    @Bean
    public Queue stockDelayQueue() {
        HashMap<String, Object> arguments = Maps.newHashMap();
        arguments.put("x-dead-letter-exchange", "stock-event-exchange");
        arguments.put("x-dead-letter-routing-key", "stock.release");
        // 消息过期时间 2分钟
        arguments.put("x-message-ttl", 120000);
        Queue queue = new Queue("stock.delay.queue", true, false, false, arguments);
        return queue;
    }

    /**
     * @description 交换机与普通队列绑定
      * @param:
     * @date: 2022/9/13 9:17
     * @return: org.springframework.amqp.core.Binding
     * @author: xjl
    */
    @Bean
    public Binding stockReleaseBinding() {
        Binding binding = new Binding("stock.release.stock.queue",Binding.DestinationType.QUEUE,"stock-event-exchange","stock.release.#",null);
        return binding;
    }

    /**
     * @description 交换机与延迟队列绑定
      * @param:
     * @date: 2022/9/13 9:17
     * @return: org.springframework.amqp.core.Binding
     * @author: xjl
    */
    @Bean
    public Binding stockLockedBinding() {
        return new Binding("stock.delay.queue",Binding.DestinationType.QUEUE,"stock-event-exchange","stock.locked",null);
    }
}
