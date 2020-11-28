package com.besti.springcloud.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Jack Pan
 * @version 1.0 2020/10/29
 */
@Configuration
public class RabbitMQConfig {

    //队列过期时间
    private int userQueueTTL = 5000;

    @Bean
    public TopicExchange topicEchange(){
        return new TopicExchange(RabbitConstants.USER_EXCHANGE);
    }

//    @Bean(name="delete_message")
//    public Queue deletequeue(){
//        return  new Queue("topic.find");
//    }

    @Bean(name="createuser_message")
    public Queue createqueue(){
        return QueueBuilder.durable(RabbitConstants.USER_QUEUE)
                .ttl(userQueueTTL)
                .deadLetterRoutingKey(RabbitConstants.DEAD_ROUTE_KEY)//设置死信队列的RouteKey
                .deadLetterExchange(RabbitConstants.DEAD_EXCHANGE)//设置死信队列的Exchange
                .build();
    }

//    @Bean(name="usercount_message")
//    public Queue usercountqueue(){
//        return  new Queue("topic.usercount");
//    }

//    @Bean
//    public Binding deleteByid_binding(@Qualifier("delete_message") Queue queue, TopicExchange topicExchange){
//
//        return BindingBuilder.bind(queue).to(topicExchange).with("topic.find.routingkey");
//    }

//

    @Bean
    public Binding orderBinding() {
        return BindingBuilder.bind(createqueue())
                .to(topicEchange())
                .with(RabbitConstants.USER_ROUTE_KEY);
    }

//    @Bean
//    public Binding usercount_binding(@Qualifier("usercount_message") Queue queue,TopicExchange topicExchange){
//
//        return BindingBuilder.bind(queue).to(topicExchange).with("topic.usercount.routingkey");
//    }


//###############################################################################################
    //配置死信队列
    @Bean(name="dead_queue")
    public Queue deadQueue() {
        return new Queue(RabbitConstants.DEAD_QUEUE);
    }

    @Bean
    public TopicExchange deadExchange() {
        return new TopicExchange(RabbitConstants.DEAD_EXCHANGE);
    }

    @Bean
    public Binding deadBinding() {
        return BindingBuilder.bind(deadQueue())
                .to(deadExchange())
                .with(RabbitConstants.DEAD_ROUTE_KEY);

    }
}
