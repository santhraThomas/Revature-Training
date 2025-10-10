package com.revature.spring.rest.spring_rest.model;

public class User { // Model class representing a User
    private int id;
    private String name;
    private int age;

    public User() {// Default constructor
    }

    public User(int id, String name, int age) {// Parameterized constructor
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }   
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
