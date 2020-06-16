package com.zc.mybatisplustest.rabbitconfig.fanout.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

@Configuration
@RabbitListener(queues = "fanout.B")
public class ConsumerFanoutB<T> {

    @RabbitHandler
    public void process(T testMessage) {
        System.out.println("FanoutReceiverB消费者收到消息  : " +testMessage.toString());
    }
}
