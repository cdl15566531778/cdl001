package com.jbt.dao;

import com.jbt.model.User;

import java.util.List;

public interface UserDao {

    //查询所有用户
    public List<User> findAll();

    //根据id来查询对应的用户
    public User findOne(Integer id);

    //添加一个用户
    public int addUser(User user);
}
