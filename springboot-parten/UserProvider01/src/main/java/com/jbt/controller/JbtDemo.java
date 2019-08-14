package com.jbt.controller;

import com.jbt.bean.User;
import com.jbt.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class JbtDemo {

    @Resource
    UserService userService;

    @GetMapping("/")
    public Map HolleSpring(){
        Map<String,Object> map=new HashMap<>();

        //熔断超时6秒
        try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<User> userList = userService.findAll();
        //封装数据集合到map
        map.put("list",userList);
        //封装服务提供方名称
        map.put("ProviderVersion","用户服务UserProvider01");
        return map;
    }

    //添加用户
    @PostMapping("/")
    public String add(@RequestBody User user){
        try {
            userService.addUser(user);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
    }

    //删除用户
    @RequestMapping("/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        try {
            userService.deleteUser(id);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
    }

    //指定id查询
    @GetMapping("/{id}")
    public User findOne(@PathVariable("id") Integer id){
        return userService.findOne(id);
    }

    //修改
    @PutMapping("/{id}")
    public String updateUser(@PathVariable("id") Integer id, @RequestBody User user){
        try {
            userService.updateUser(id, user);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
}
