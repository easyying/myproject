package com.daguo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 * 验证过滤器
 */
@RestController
@RequestMapping("/filtercontro")
public class MyController {
    @RequestMapping("getHelloFilter")
    public String getHello() throws InterruptedException {
        Thread.sleep(1000);
        return "Hello";
    }
}
