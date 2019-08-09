package com.jbt.service.impl;

import com.jbt.dao.UserDao;
import com.jbt.model.User;
import com.jbt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        List<User> list = userDao.findAll();
        return list;
    }

    @Override
    public User findOne(Integer id) {
        System.out.println("查询到一个用户");
        return null;
    }

    @Override
    public int addUser(User user) {
        System.out.println("添加成功");
        return 0;
    }


}
