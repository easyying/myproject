package com.daguo.advanced.exception;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.common.collect.ImmutableMap;
/**
 * @author
 */
@RestController
public class Exception1Controller {
    @GetMapping("/resourceNotFound")
    public void throwException1(){
        Person person = new Person(1,"大大");
        throw new ResourceNotFoundException(ImmutableMap.of("person id:", person.getId()));
    }
}
