package com.example.mutipledatasource.db1.service.impl;

import com.example.mutipledatasource.bean.User;
import com.example.mutipledatasource.db1.dao.UserDao1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl1 implements UserService1 {
    @Autowired
    private UserDao1 userDao;

    /**
     * 根据名字查找用户
     */
    @Override
    public User selectUserByName(String name) {
        return userDao.findUserByName(name);
    }

}
