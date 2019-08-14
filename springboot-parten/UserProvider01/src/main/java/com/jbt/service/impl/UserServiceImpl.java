package com.jbt.service.impl;

import com.jbt.bean.User;
import com.jbt.dao.UserDao;
import com.jbt.service.UserService;
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
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userDao.deleteUser(id);
    }

    @Override
    public void updateUser(Integer id, User user) {
        userDao.updateUser(id,user);
    }

    @Override
    public User findOne(Integer id) {
        return userDao.findOne(id);
    }
}
