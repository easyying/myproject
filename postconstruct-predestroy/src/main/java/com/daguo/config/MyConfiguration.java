package com.daguo.config;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * serverlet的生命周期：构造方法-  @PostConstruct- init () -service() -destroy()- @PreDestroy-回收
 * 作用：
 * @PostConstruct : 用来修饰方法，标记在项目启动的时候执行这个方法,一般用来执行某些初始化操作比如全局配置。
 * PostConstruct 注解的方法会在构造函数之后执行,Servlet 的init()方法之前执行。
 @PreDestroy : 当 bean 被 Web 容器的时候被调用，一般用来释放 bean 所持有的资源。
 @PreDestroy 注解的方法会在Servlet 的destroy()方法之前执行。
 */
@Component
public class MyConfiguration {
    public MyConfiguration(){
        System.out.println("构造方法被调用");
    }

    @PostConstruct
    private void init(){
        System.out.println("PostConstruct注解方法被调用");
    }

    @PreDestroy
    private void destroy(){
        System.out.println("PreDestroy注解方法被调用");
    }
}
