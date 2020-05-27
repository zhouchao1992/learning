package com.zc.mybatisplustest.rabbitconfig.topic.provider;

/**
 * 直连型交换机 key
 */
public class Constants {
    //绑定键
    public final static String TOPIC_SEND_MAN = "send.man";
    public final static String TOPIC_SEND_WOMAN = "topic.woman";
    //交换机名称
    public final static String TOPIC_SEND_EXCHANGE = "topicExchange";
    //路由规则匹配设置  这样只要是消息携带的路由键是以topic.开头,都会分发到该队列
    public final static String TOPIC_SEND_ROUTE = "topic.*";

}
