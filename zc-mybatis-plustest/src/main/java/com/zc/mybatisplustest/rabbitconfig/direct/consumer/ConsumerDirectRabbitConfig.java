package com.zc.mybatisplustest.rabbitconfig.direct.consumer;

import com.zc.mybatisplustest.rabbitconfig.direct.provider.Constants;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**直连型交换机实现方法
 * 消费者单纯的使用，其实可以不用添加这个配置，直接建后面的监听就好，
 * 使用注解来让监听器监听对应的队列即可。配置上了的话，其实消费者也是生成者的身份，也能推送该消息
 */
@Configuration
public class ConsumerDirectRabbitConfig {
    //队列 起名：sendDirectQueue
    @Bean(name = "consumerDirectQueue")
    public Queue consumerDirectQueue() {
        return new Queue(Constants.PROVIDER_QUEUE_NAME,true);
    }

    //Direct交换机 起名：sendDirectExchange
    @Bean(name = "consumerDirectExchange")
    DirectExchange consumerDirectExchange() {
        return new DirectExchange(Constants.PROVIDER_EXCHANGE_NAME);
    }

    //绑定  将队列和交换机绑定, 并设置用于匹配键：TsendDirectRouting
    @Bean(name = "consumerbindingDirect")
    Binding consumerbindingDirect() {
        return BindingBuilder.bind(consumerDirectQueue()).to(consumerDirectExchange()).with(Constants.PROVIDER_QUEUE_ROUTE_KEY);
    }
}
