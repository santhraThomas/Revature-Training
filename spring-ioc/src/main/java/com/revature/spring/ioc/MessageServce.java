package com.revature.spring.ioc;

public class MessageServce {
    private String message;

    public MessageServce(String message) {
        this.message = message;
    }

    public void printMessage() {
        System.out.println("Your message: " + message);
    }
}
