package com.example.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public Queue queue1(){
        return new Queue("queue1");
    }

    @Bean
    public Queue queue2(){
        return new Queue("queue2");
    }

//    @Bean
//    DirectExchange directExchange(){
//        return new DirectExchange("directExchange");
//    }

//    @Bean
//    TopicExchange topicExchange(){
//        return new TopicExchange("topicExchange");
//    }
//
    @Bean
    FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExchange");
    }

    //扇形
    @Bean
    Binding bingdingExchangeMessage1(Queue queue1, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queue1).to(fanoutExchange);
    }

    @Bean
    Binding bingdingExchangeMessage2(Queue queue2, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queue2).to(fanoutExchange);
    }

/*
主题
    @Bean
    Binding bingdingExchangeMessage3(Queue queue1, TopicExchange topicExchange){
        return BindingBuilder.bind(queue1).to(directExchange).with("aa.#");
    }
*/
    /*
直连
    @Bean
    Binding bingdingExchangeMessage3(Queue queue1, DirectExchange directExchange){
        return BindingBuilder.bind(queue1).to(directExchange).with("1");
    }
*/


}
