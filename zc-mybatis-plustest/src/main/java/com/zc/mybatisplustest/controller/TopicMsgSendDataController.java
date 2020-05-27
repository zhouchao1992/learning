package com.zc.mybatisplustest.controller;

import com.zc.mybatisplustest.rabbitconfig.topic.provider.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/topic/msg/send/")
@Api(tags = "主题型交换机------->消息推送")
public class TopicMsgSendDataController {
    @Resource
    RabbitTemplate rabbitTemplate;
    //这个消息发送到第一个队列中，精准匹配的
    @GetMapping("/sendTopicMessage1")
    @ApiOperation("消息发送到man队列中")
    public String sendTopicMessage1() {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "message: M A N ";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> manMap = new HashMap<>();
        manMap.put("messageId", messageId);
        manMap.put("messageData", messageData);
        manMap.put("createTime", createTime);
        rabbitTemplate.convertAndSend(Constants.TOPIC_SEND_EXCHANGE, Constants.TOPIC_SEND_MAN, manMap);
        return "ok";
    }

    //这个消息发送到第二个队列中，通过topic.#去匹配的
    @GetMapping("/sendTopicMessage2")
    @ApiOperation("消息发送到非man队列中")
    public String sendTopicMessage2() {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "message: woman is all ";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> womanMap = new HashMap<>();
        womanMap.put("messageId", messageId);
        womanMap.put("messageData", messageData);
        womanMap.put("createTime", createTime);
        rabbitTemplate.convertAndSend(Constants.TOPIC_SEND_EXCHANGE, Constants.TOPIC_SEND_WOMAN, womanMap);
        return "ok";
    }
}
