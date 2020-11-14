package com.besti.springcloud.Rabbitmq;

import com.besti.springcloud.config.RabbitConstants;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author Jack Pan
 * @version 1.0 2020/10/29
 */
@Component
public class Sender implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnCallback{

    @Autowired
    public AmqpTemplate rabbitAmqpTemplate;

    @Autowired
    public RabbitTemplate rabbitTemplate;

    private RabbitConstants rabbitConstants;


    @Autowired
    public void TopicSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        rabbitTemplate.setConfirmCallback(this);
    }


    public void sendTopicDelete(String exchange,String routekey,long msg){
        //向消息队列发送消息
        //参数一：交换器名称
        //参数二：路由键
        //参数三：消息
        rabbitAmqpTemplate.convertAndSend(exchange,routekey,msg);

    }

    public void sendTopicCreateUser(String msg){
        //向消息队列发送消息
        //参数一：交换器名称
        //参数二：路由键
        //参数三：消息
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        System.out.println("callbackSender UUID: " + correlationData.getId());
        rabbitTemplate.convertAndSend(rabbitConstants.USER_EXCHANGE,rabbitConstants.USER_ROUTE_KEY,msg,correlationData);

    }

    public void sendTopicUsercount(String exchange,String routekey,long msg){
        //向消息队列发送消息
        //参数一：交换器名称
        //参数二：路由键
        //参数三：消息
        rabbitAmqpTemplate.convertAndSend(exchange,routekey,msg);

    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack,String s) {
        System.out.println("消息发送成功,发送ack确认,id="+correlationData.getId());
        if (ack){
            System.out.println("发送成功");
        }else {
            System.out.println("发送失败");
        }
    }

    @Override
    public void returnedMessage(Message message, int i, String s, String s1, String s2) {
        System.out.println("消息丢失, 没有投递成功");
    }
}
