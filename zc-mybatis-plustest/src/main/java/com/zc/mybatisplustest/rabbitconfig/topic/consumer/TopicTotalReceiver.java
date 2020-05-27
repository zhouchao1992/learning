package com.zc.mybatisplustest.rabbitconfig.topic.consumer;

import com.zc.mybatisplustest.rabbitconfig.topic.provider.Constants;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

@Configuration
@RabbitListener(queues = Constants.TOPIC_SEND_WOMAN)
public class TopicTotalReceiver<T> {

    @RabbitHandler
    public void msg(T  msg){
        System.err.println("接收到非man信息，信息体为："+msg.toString());
    }
}
