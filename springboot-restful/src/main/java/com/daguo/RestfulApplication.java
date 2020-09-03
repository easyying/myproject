package com.daguo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author
 * 这是因为添加了数据库组件，所以autoconfig会去读取数据源配置，而新建的项目还没有配置数据源，所以会导致异常出现。
 * 解决办法：

1.去掉数据库依赖
2.在启动类的@EnableAutoConfiguration或@SpringBootApplication中添加exclude = {DataSourceAutoConfiguration.class}，排除此类的autoconfig。启动以后就可以正常运行。
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class RestfulApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(RestfulApplication.class,args);
    }

}
