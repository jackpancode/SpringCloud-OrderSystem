package com.besti.springcloud.config;

/**
 * @author Jack Pan
 * @version 1.0 2020/11/13
 */
public class RabbitConstants {

    //订单队列
    public static final String USER_ROUTE_KEY = "order_route_key";
    public static final String USER_EXCHANGE = "exchange-test";
    public static final String USER_QUEUE = "order_queue";

    //死信队列
    public static final String DEAD_QUEUE = "dead_queue";
    public static final String DEAD_EXCHANGE = "dead_exchange";
    public static final String DEAD_ROUTE_KEY = "dead_route_key";
}
