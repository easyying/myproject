package com.daguo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author
 * 定义：
 * 作用：
 * 原理：AOP
 * 实现步骤：
 *     自定义拦截器：如果你需要自定义 Interceptor 的话必须实现 org.springframework.web.servlet.HandlerInterceptor接口或继承 org.springframework.web.servlet.handler.HandlerInterceptorAdapter类，并且需要重写下面下面3个方法
 *     定义配置拦截器的配置文件并&&在配置文件中配置拦截器
 *        能够配置每个拦截器拦截哪些请求以及拦截器的顺序
 *
 *
 * 测试拦截器
 */
@Controller
public class InterceptorController {

    @RequestMapping("/admin/oldLogin")//拦截器会将其重定向到/admin/login
    public String oldLogin(Model model){
        return "oldLogin";
    }

    @RequestMapping("/admin/login")
    public String login(Model model){
        System.out.println("\n-------- MainController.login --- ");
        System.out.println(" ** You are in Controller ** ");
        return "login";
    }

    @RequestMapping(value = { "/", "/test" })
    public String test(Model model) {

        System.out.println("\n-------- MainController.test --- ");

        System.out.println(" ** You are in Controller ** ");

        return "test";
    }
}
