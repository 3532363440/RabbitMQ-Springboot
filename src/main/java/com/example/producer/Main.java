package com.example.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Main {
    @Autowired
    private ProducerMessage producerMessage;

    @RequestMapping("aa")
    public String send(){
        producerMessage.send();
        return "发送成功";
    }
}
