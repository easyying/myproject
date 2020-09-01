package com.example.myproject;


import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@EnableAutoConfiguration
public class ApplicationC {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ApplicationC.class, args);
    }
}
