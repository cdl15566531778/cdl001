package com.example.demo.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author caidonglin
 * @Date 2019/9/18
 */
@Component
public class emailService {

    /**
     * 接收消息的方法，采用消息队列监听机制
     * @param msg
     */
    @RabbitListener(queues = "queue")
    public void process(Integer id){
        System.out.println("Email接受到的用户id:"+id);
    }
}
