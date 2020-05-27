package com.zc.mybatisplustest.rabbitconfig.direct.provider;

/**
 * 直连型交换机 key
 */
public class Constants {
    /**
     * 发送消息队列的配置
     */
    //发送消息的交换机名称
    public static final String SEND_EXCHANGE_NAME = "sendDirectExchange";
    //发送消息的队列名称
    public static final String SEND_QUEUE_NAME = "sendDirectQueue";
    //发送消息的队列路由键
    public static final String SEND_QUEUE_ROUTE_KEY = "sendDirectRouting";


    /**
     * 接收到消息后返回队列的配置
     */
    //接收返回数据的交换机名称
    public static final String PROVIDER_EXCHANGE_NAME = "providerDirectExchange";
    //接收返回数据的队列名称
    public static final String PROVIDER_QUEUE_NAME = "providerDirectQueue";
    //发接收返回数据的队列路由键
    public static final String PROVIDER_QUEUE_ROUTE_KEY = "providerDirectRouting";

}
