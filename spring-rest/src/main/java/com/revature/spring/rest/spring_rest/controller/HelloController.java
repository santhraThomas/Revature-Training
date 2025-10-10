package com.revature.spring.rest.spring_rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // Marks this class as a Spring MVC controller
public class HelloController {
    @ResponseBody // Indicates that the return value should be used as the response body
    public String hello() {
        return "Hello, World!";
    }
}
