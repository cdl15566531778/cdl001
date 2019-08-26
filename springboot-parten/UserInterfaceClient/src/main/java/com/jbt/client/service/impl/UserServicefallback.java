package com.jbt.client.service.impl;


import com.github.pagehelper.PageInfo;
import com.jbt.bean.TbItemCat;
import com.jbt.bean.User;
import com.jbt.client.service.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserServicefallback implements UserService {
    @Override
    public Map findAll() {
        Map map = new HashMap();
        map.put("list", new ArrayList<>());
        map.put("ProviderVersion", "获取远程调用失败");
        return map;
    }

    @Override
    public void addUser(User user) {
        System.out.println("创建失败");
    }

    @Override
    public void deleteUser(Integer id) {
        System.out.println("删除失败");
    }

    @Override
    public void updateUser(Integer id, User user) {

    }

    @Override
    public User findOne(Integer id) {
        return null;
    }

    @Override
    public PageInfo<User> pageList(Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public List<User> searchUser(String username) {
        return null;
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public List<TbItemCat> findCategory1(TbItemCat itemCat) {
        return null;
    }


}
