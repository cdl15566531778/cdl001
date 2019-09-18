package com.cdl.springbootactivitemq.controller;

import com.cdl.springbootactivitemq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author caidonglin
 * @Date 2019/8/21
 *
 * 消息生产者
 *
 */
@RestController
public class MyActiviteMq {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @RequestMapping("/send")
    public String send(String user){
        Map map = new HashMap();
        map.put("11",user);
        map.put("content", "恭喜获得 10 元代金券");
        jmsMessagingTemplate.convertAndSend("user",map);
        return "success";
    }

}
