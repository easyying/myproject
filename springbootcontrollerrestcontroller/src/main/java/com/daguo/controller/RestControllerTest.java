package com.daguo.controller;

import com.daguo.model.Person;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerTest {

    @PostMapping("/helloCon1")//postman http://localhost:8080/helloCon1
    public Person greeting(@RequestBody Person person) {
        return person;
    }
}
