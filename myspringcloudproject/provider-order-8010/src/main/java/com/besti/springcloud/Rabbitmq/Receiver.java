package com.besti.springcloud.Rabbitmq;

import com.alibaba.fastjson.JSONObject;
import com.besti.springcloud.config.RabbitConstants;
import com.besti.springcloud.entity.Order;
import com.besti.springcloud.entity.User;
import com.besti.springcloud.repository.OrderRepository;
import com.besti.springcloud.repository.UserRepository;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author Jack Pan
 * @version 1.0 2020/10/29
 */
@Component
public class Receiver {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private Sender sender;


    @RabbitListener(queues = "topic.createuser")
    public void getMsgCreate(Message message, Channel channel) throws Exception{
        String receivedRoutingKey = message.getMessageProperties().getReceivedRoutingKey();
        String msg = new String(message.getBody());
        System.out.println("路由key= [ "+receivedRoutingKey+" ]接收到的消息= [ "+msg +" ]");
        Order order = JSONObject.parseObject(msg,Order.class);
        orderRepository.save(order);

        channel.basicAck(message.getMessageProperties().getDeliveryTag(),true);
    }

    // 监听死信队列
    @RabbitListener(queues = RabbitConstants.DEAD_QUEUE)
    public void deadQueueListener(Message message, Channel channel) throws InterruptedException, IOException {
        String receivedRoutingKey = message.getMessageProperties().getReceivedRoutingKey();
        String msg = new String(message.getBody());
        System.out.println("路由key= [ "+receivedRoutingKey+" ]接收到的消息= [ "+msg +" ]");
        //Thread.sleep(5000);
        // 发送ack给消息队列，收到消息了
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),true);

    }

}
