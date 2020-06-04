/*
package com.zc.mybatisplustest.rabbitconfig.topic.consumer;

import com.zc.mybatisplustest.rabbitconfig.topic.provider.Constants;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

@Configuration
@RabbitListener(queues = Constants.TOPIC_SEND_MAN)
public class TopicManReceiver<T> {

    @RabbitHandler
    public  void  msg(T msg){
        System.out.println("接收到man消息！------>消息为："+msg.toString());
    }
}
*/
