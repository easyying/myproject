package com.daguo;

import com.daguo.config.MyConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LifeScyleAnnotationApplication {
    public static void main(String[] args) {
        MyConfiguration  myConfiguration = new MyConfiguration();
        SpringApplication.run(LifeScyleAnnotationApplication.class,args);
    }
}
