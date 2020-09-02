package com.example.mutipledatasource.service.user1.impl;

import com.example.mutipledatasource.bean.User;
import com.example.mutipledatasource.dao.db1.UserDao1;
import com.example.mutipledatasource.service.user1.UserService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl1 implements UserService1 {
    @Autowired
    private UserDao1 userDao1;

    /**
     * 根据名字查找用户
     */
    @Override
    public User selectUserByName1(String name) {
        return userDao1.findUserByName1(name);
    }

}
