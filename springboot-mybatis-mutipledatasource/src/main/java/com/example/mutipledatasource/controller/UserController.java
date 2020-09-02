package com.example.mutipledatasource.controller;

import com.example.mutipledatasource.bean.User;
import com.example.mutipledatasource.service.user1.UserService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user1")
public class UserController {
    @Autowired
    private UserService1 userService1;

    @RequestMapping("/query")
    public User testQuery() {
        return userService1.selectUserByName1("哈哈");
    }
}
