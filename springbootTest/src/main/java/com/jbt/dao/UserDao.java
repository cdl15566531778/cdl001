package com.jbt.dao;

import com.jbt.model.User;

import java.util.List;

public interface UserDao {

    //查询所有用户
    public List<User> findAll();
}
