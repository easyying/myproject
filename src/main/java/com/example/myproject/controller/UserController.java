package com.example.myproject.controller;

import com.example.myproject.bean.User;
import com.example.myproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/query")
    public User testQuery() {
        return userService.selectUserByName("哈哈");
    }

    @RequestMapping("/query1")
    public User testQuery1() {
        User user = new User();
        user.setName("哈哈");
        user.setAge(21);
        return userService.selectUser("哈哈",21);
    }
    @RequestMapping("/query2")
    public User testQuery2() {
        User user = new User();
        user.setName("哈哈");
        user.setAge(21);
        return userService.selectUser2("哈哈",21);
    }


    @RequestMapping("/insert")
    public List<User> testInsert() {
        userService.insertService();
        return userService.selectAllUser();
    }


    @RequestMapping("/changemoney")
    public List<User> testchangemoney() {
        //userService.changemoney();
        return userService.selectAllUser();
    }

    @RequestMapping("/delete")
    public String testDelete() {
        userService.deleteService(3);
        return "OK";
    }
}
