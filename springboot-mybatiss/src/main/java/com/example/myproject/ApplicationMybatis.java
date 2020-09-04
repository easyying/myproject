package com.example.myproject;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class ApplicationMybatis {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ApplicationMybatis.class, args);
    }
}
