package com.jbt.service;


import com.jbt.bean.User;

import java.util.List;

public interface UserService {

    //查询所有用户
    public List<User> findAll();

    //添加用户
    public void addUser(User user);

    //删除用户
    public void deleteUser(Integer id);

    //修改用户
    public void updateUser(Integer id,User user);

    //查询指定id
    public User findOne(Integer id);
}
