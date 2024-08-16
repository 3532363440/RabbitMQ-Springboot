package com.example.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 发送消息*/
@Component
public class ProducerMessage {
    @Autowired
    private AmqpTemplate template;
    public void send(){
        for(int i = 0; i<10; i++){
            String message = "我是" +i;
            System.out.println("发送了"+message);
            this.template.convertAndSend("fanoutExchange", "1", message);

        }
    }
}
