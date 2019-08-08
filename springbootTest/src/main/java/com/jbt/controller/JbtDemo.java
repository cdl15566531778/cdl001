package com.jbt.controller;

import com.jbt.model.User;
import com.jbt.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class JbtDemo {

    @Resource
    UserService userService;

    @RequestMapping("/findAll")
    public List<User> HolleSpring(){
        List<User> list = userService.findAll();
        return list;
    }
}
