package com.daguo.controller;

import com.daguo.model.UserWebModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 * 测试@RestController ：将返回的对象数据直接以 JSON 或 XML 形式写入 HTTP 响应(Response)中
 */
@RestController
public class HelloController {
    @RequestMapping("/getUser")
    public UserWebModel getUser(){
        UserWebModel userWebModel = new UserWebModel();
        userWebModel.setId(1L);
        userWebModel.setNickName("micheel");
        return userWebModel;
    }
}
