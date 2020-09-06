package com.daguo.controller;
import com.daguo.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControllerTest {

    @PostMapping("/helloCon")
    @ResponseBody
    public Person greeting(@RequestBody Person person) {
        return person;
    }
}
