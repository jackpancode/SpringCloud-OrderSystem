package com.besti.springcloud.config;

/**
 * @author Jack Pan
 * @version 1.0 2020/10/29
 */
//@Configuration
//public class RabbitMQConfig {
//
//    @Bean
//    public TopicExchange topicEchange(){
//        return new TopicExchange("exchange-test-1");
//    }
//
//    @Bean(name="sendUserCount")
//    public Queue queue(){
//        return  new Queue("topic.sendusercount");
//    }
//
//    @Bean
//    public Binding sendUserCount(@Qualifier("sendUserCount") Queue queue, TopicExchange topicExchange){
//
//        return BindingBuilder.bind(queue).to(topicExchange).with("topic.usercount.routingkey");
//    }
//}
