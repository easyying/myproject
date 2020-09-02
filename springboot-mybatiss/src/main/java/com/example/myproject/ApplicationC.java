package com.example.myproject;


import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;

@SpringBootApplication
@EnableAutoConfiguration
public class ApplicationC {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ApplicationC.class, args);
    }
}
