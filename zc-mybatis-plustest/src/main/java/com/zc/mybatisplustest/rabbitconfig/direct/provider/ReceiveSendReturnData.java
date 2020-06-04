/*
package com.zc.mybatisplustest.rabbitconfig.direct.provider;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

*/
/**
 * 直连型交换机消息消费
 *//*

@Component
@RabbitListener(queues = Constants.PROVIDER_QUEUE_NAME) //监听的队列名称
public class ReceiveSendReturnData<T> {
    @Autowired
    RabbitTemplate rabbitTemplate;  //使用RabbitTemplate,这提供了接收/发送等等方法

    @RabbitHandler
    public void process(T testMessage) {
        System.err.println("接收到请求返回信息  : " + testMessage.toString());
    }
}
*/
