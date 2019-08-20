package com.jbt.service;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.jbt.bean.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

public interface UserService {

    //查询所有用户
    @GetMapping(value = "/")
    public Map findAll();
    //添加用户
    @PostMapping(value = "/")
    public String addUser(User user);

    //删除用户
    @DeleteMapping(value = "/{id}")
    public String deleteUser(Integer id);

    //修改用户
    @PutMapping(value = "/{id}")
    public String updateUser(Integer id,User user);

    //查询指定id
    @GetMapping(value = "/{id}")
    public User findOne(Integer id);

    //分页
    @GetMapping("/{pageNum}/{pageSize}")
    public PageInfo<User> pageList(Integer pageNum, Integer pageSize);

    //添加查询接口
    @GetMapping("/search/{username}")
    public List<User> searchUser(String username);

    //登陆，根据用户名查找用户dsfdsfs
    @GetMapping("/login/{username}")
    public User findByUsername(String username);
}
