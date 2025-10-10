package com.revature.spring.rest.spring_rest.controller;

import com.revature.spring.rest.spring_rest.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/users") // Base path for all endpoints in this controller 
public class UserController {
    // In a real application, this would be replaced with a service or repository
    private static List<User> users = new ArrayList<>(Arrays.asList(
        new User(1, "Santhra", 30),
        new User(2, "Joseph", 25)
    ));

    @GetMapping("/{id}") // Handles GET requests to /users/{id}
    // Example: http://localhost:8080/users/1
    public User getUserById(@PathVariable int id) {
        return users.stream()
                    .filter(user -> user.getId() == id)
                    .findFirst()
                    .orElse(null); // Returns the user with the specified ID or null if not found
    }

    @GetMapping("/response/{id}")
    public ResponseEntity<User> getUserResponse(@PathVariable int id) {
        return users.stream()
                    .filter(user -> user.getId() == id)
                    .findFirst()
                    .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping // Handles GET requests to /users
    public List<User> getAllUsers() {
        return users; // Returns the list of all users
    }

    @PostMapping // Handles POST requests to /users
    // Example: http://localhost:8080/users with JSON body
    public ResponseEntity<String> createUser(@RequestBody User user) {
        users.add(user); // Adds the new user to the list
        return new ResponseEntity<>("User created successfully", HttpStatus.CREATED);
    }
    
}
