package com.daguo.config;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * serverlet的生命周期：构造方法-  @PostConstruct- init () -service() -destroy()- @PreDestroy-回收
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
