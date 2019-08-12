package com.jbt.dao.impl;

import com.jbt.dao.UserDao;
import com.jbt.model.User;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoImpl  {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>(1);
        map.put("1","1");
        map.put("2","2");
        for (Map.Entry entry : map.entrySet()){
            System.out.println(entry.getKey()+"   " + entry.getValue());
        }
    }

}
