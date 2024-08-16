package com.example.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "queue1")
public class ConsumerMessage {

    @RabbitHandler
    public void process(String message){
        System.out.println("消费的消息是："+message);
    }

}
