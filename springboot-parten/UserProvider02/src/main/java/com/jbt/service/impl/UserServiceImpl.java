package com.jbt.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jbt.bean.User;
import com.jbt.dao.UserDao;
import com.jbt.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public Map findAll() {

        Map<String,Object> map=new HashMap<>();
        //熔断超时6秒

        try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<User> userList = userDao.findAll();
        //封装数据集合到map
        map.put("list",userList);
        //封装服务提供方名称
        map.put("ProviderVersion","用户服务UserProvider02");
        return map;
//        List<User> list = userDao.findAll();
    }

    @Override
    public String addUser(@RequestBody User user) {
        try {
            userDao.addUser(user);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
    }

    @Override
    public String deleteUser(@PathVariable("id") Integer id) {
        System.out.println("进入删除");
        System.out.println(id);
        try {
            userDao.deleteUser(id);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
    }

    @Override
    public String updateUser(@PathVariable("id") Integer id,@RequestBody User user) {
        try {
            userDao.updateUser(id, user);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @Override
    public User findOne(@PathVariable("id") Integer id) {
        return userDao.findOne(id);
    }

    @Override
    public PageInfo<User> pageList(Integer pageNum, Integer pageSize) {
        System.out.println(pageNum + pageSize);
        PageHelper.startPage(pageNum, pageSize);
        Page<User> list =  userDao.pageList();
        System.out.println(list);
        PageInfo<User> pageInfo = new PageInfo<>(list);
        System.out.println(pageInfo);
        return pageInfo;
    }
}
