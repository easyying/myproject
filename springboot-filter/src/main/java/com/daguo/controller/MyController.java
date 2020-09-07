package com.daguo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 * 验证过滤器：
 * 原理：Filter 过滤器是面向切面编程——AOP 的具体实现
 * 作用：过滤用户请求的，它允许我们对用户请求进行前置处理和后置处理：比如实现URL级别的权限控制、过滤非法请求等等
 *
 * 1. 定义过滤器MyFilter：要实现Filter接口
 * 2. 定义配置MyFilterConfig
 * 3. 在配置中注册自定义的过滤器（配置过滤器：包括配置过滤器的顺序）
 *    手动配置 @@Autowired private MyFilter myFilter;
 *    注解实现（还未跑通）
 * 4. 过滤器的执行顺序可以自定义
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
