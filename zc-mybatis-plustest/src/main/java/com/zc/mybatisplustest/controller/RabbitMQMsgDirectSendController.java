package com.zc.mybatisplustest.controller;

import com.zc.mybatisplustest.rabbitconfig.direct.provider.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * rabbitmq  消息注册  推送   直连型交换机实现方法
 */
@RestController
@RequestMapping("/send/")
@Api(tags = "rabbitmq消息推送测试")
public class RabbitMQMsgDirectSendController {
    @Autowired
    RabbitTemplate rabbitTemplate;  //使用RabbitTemplate,这提供了接收/发送等等方法

    @GetMapping("sendDirectMessage")
    @ApiOperation(value = "消息发送")
    public String sendDirectMessage(String msg) {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = msg;
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String,Object> map=new HashMap<>();
        map.put("messageId",messageId);
        map.put("messageData",messageData);
        map.put("createTime",createTime);
        //将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
        rabbitTemplate.convertAndSend(Constants.SEND_EXCHANGE_NAME, Constants.SEND_QUEUE_ROUTE_KEY, map);
        return "ok";
    }
}
