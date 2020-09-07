package com.daguo.method1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {
    @GetMapping("/illegalArgumentException")
    public void throwException1(){
        throw new IllegalArgumentException();
    }

    @GetMapping("/businessException")
    public void throwException2(){
        throw new BusinessException();
    }

}
