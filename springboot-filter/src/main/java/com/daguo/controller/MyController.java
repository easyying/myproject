package com.daguo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 * 验证过滤器
 *
 * 1. 定义过滤器MyFilter：要实现Filter接口
 * 2. 定义配置MyFilterConfig
 * 3. 在配置中注册自定义的过滤器
 *    手动配置 @@Autowired private MyFilter myFilter;
 *    注解实现（还未跑通）
 *
 *
 */
@RestController
@RequestMapping("/filtercontro")
public class MyController {
    @RequestMapping("/getHelloFilter")
    public String getHello() throws InterruptedException {
        Thread.sleep(1000);
        return "Hello";
    }
}
