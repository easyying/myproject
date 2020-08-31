package com.example.myproject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ha
 */
@RestController
public class HelloWorldController {

    /**
     * 页面请求：http://localhost:8080/hello
     * @return
     */
    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }
}
