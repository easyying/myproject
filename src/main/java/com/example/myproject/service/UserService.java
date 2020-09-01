package com.example.myproject.service;

import com.example.myproject.bean.User;

import java.util.List;

public interface UserService {

    /**
     * mapper
     */
    User selectUserByName(String name);
    User selectUser(String name, int age);
    User selectUser2(String name, int age);

    /**
     * 注解
     */
    List<User> selectAllUser();
    void insertService();
    void deleteService(int id);
    void changemoney();
}
