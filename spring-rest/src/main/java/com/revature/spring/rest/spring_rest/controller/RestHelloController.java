package com.revature.spring.rest.spring_rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api") // Base path for all endpoints in this controller
public class RestHelloController {

    @GetMapping("/greeting") // Handles GET requests to /api/greeting
    // Example: http://localhost:8080/api/greeting
    public String greeting() {
        return "Hello from Controller!";// Simple greeting message
    }
}
