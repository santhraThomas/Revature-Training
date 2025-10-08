package com.revature.spring.ioc;

public class MessageServce {
    private String message;

    //For setter method injection you need a No-Arg constructor
    public MessageServce() {
    }
    
    //Setter method for dependency injection so the message is now injected via the setter method
    public void setMessage(String message) {
        this.message = message;
    }

    public void printMessage() {
        System.out.println("Your message: " + message);
    }
}
