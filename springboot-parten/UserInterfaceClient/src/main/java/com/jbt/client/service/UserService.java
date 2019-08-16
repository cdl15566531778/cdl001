package com.jbt.client.service;


import com.github.pagehelper.PageInfo;
import com.jbt.bean.User;
import com.jbt.client.service.impl.UserServicefallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(value = "USERPROVIDER",fallback = UserServicefallback.class)
public interface UserService {

    @GetMapping("/user/")
    public Map findAll();

    //添加用户
    @PostMapping("/user/")
    public void addUser(User user);

    //删除用户
    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable("id") Integer id);

    //修改用户
    @PutMapping("/user/{id}")
    public void updateUser(@RequestParam("id") Integer id, @RequestBody User user);

    //查询指定id
    @GetMapping("/user/{id}")
    public User findOne(@RequestParam("id") Integer id);

    @GetMapping("/user/{pageNum}/pageSize")
    public PageInfo<User> pageList(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize);

    //添加查询接口
    @GetMapping("/user/search/{username}")
    public List<User> searchUser(@PathVariable("username") String username);

    //登陆，根据用户名查找用户
    @GetMapping("/user/login/{username}")
    public User findByUsername(@PathVariable("username") String username);
}
