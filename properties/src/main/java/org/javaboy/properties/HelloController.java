package org.javaboy.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * * 读取配置文件的方法
 * 1.@Value("${ }")@value这种方式是不被推荐的  类加：@Component
 * 2.推荐：
 *  1)@ConfigurationProperties   类加：@Component
 *
 * 类：
 * 1）项目启动则注册 @Component
 * 2）类没有加 @Component 注解。我们在我们要使用类的地方使用@EnableConfigurationProperties注册我们的配置bean
 */
@RestController
@EnableConfigurationProperties(ZoomWithOutComponent.class)
public class HelloController {

    @Autowired
    Book book;
    @Autowired
    private Library library;
    @Autowired
    private ZoomWithOutComponent zoomWithOutComponent;

    //@Value
    @GetMapping("/hello")
    public String hello() {
        System.out.println(book);
        return "hello";
    }

    //@ConfigurationProperties
    @GetMapping("/getLibrary")
    public String getLibrary() {
        System.out.println(library);
        return "hello";
    }

    //类没用Component
    @GetMapping("/getZoom")
    public String getZoom() {
        System.out.println(zoomWithOutComponent);
        return "hello";
    }


}
