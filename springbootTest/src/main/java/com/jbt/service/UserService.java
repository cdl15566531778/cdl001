package com.jbt.service;

import com.jbt.model.User;

import java.util.List;

public interface UserService {

    //查询所有用户
    public List<User> findAll();
}
