package com.daguo.controller;

import com.daguo.dao.UserWebDao;
import com.daguo.model.UserWebModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 *
 */
@RestController
public class UserWebController {

    @Autowired
    private UserWebDao userWebDao;

    @RequestMapping("/insert")
    public void insert(){
        UserWebModel userWebModel = new UserWebModel();
        userWebModel.setId(1L);
        userWebModel.setUserName("张三");
        userWebModel.setEmail("123");
        userWebModel.setNickName("张三yaya");
        userWebModel.setPassWord("123");
        userWebModel.setRegTime("111");
        userWebDao.save(userWebModel);
    }

    @RequestMapping("/getUserWeb")
    public UserWebModel getUser(){
        UserWebModel userWebModel = userWebDao.findByUserName("张三");
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return userWebModel;
    }
}
