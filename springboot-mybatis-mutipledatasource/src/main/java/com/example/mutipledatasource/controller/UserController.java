package com.example.mutipledatasource.controller;

import com.example.mutipledatasource.bean.User;
import com.example.mutipledatasource.db1.service.impl.UserService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user1")
public class UserController {
    @Autowired
    private UserService1 userService;

    @RequestMapping("/query")
    public User testQuery() {
        return userService.selectUserByName("哈哈");
    }
}
