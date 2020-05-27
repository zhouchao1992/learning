package com.zc.mybatisplustest.rabbitconfig.direct.consumer;

import com.zc.mybatisplustest.rabbitconfig.direct.provider.Constants;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 直连型交换机消息消费
 */
@Component
@RabbitListener(queues = Constants.SEND_QUEUE_NAME) //监听的队列名称
public class RabbitMQMsgDirectReceiver<T> {
    @Autowired
    RabbitTemplate rabbitTemplate;  //使用RabbitTemplate,这提供了接收/发送等等方法

    @RabbitHandler
    public void process(T testMessage) {
        System.out.println("DirectReceiver消费者收到消息  : " + testMessage.toString());
        //一下部分时接收到消息后返回去的数据
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "收到了你的请求！";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String,Object> map=new HashMap<>();
        map.put("messageId",messageId);
        map.put("messageData",messageData);
        map.put("createTime",createTime);
        //将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
        rabbitTemplate.convertAndSend(Constants.PROVIDER_EXCHANGE_NAME ,Constants.PROVIDER_QUEUE_ROUTE_KEY, map);
    }
}
