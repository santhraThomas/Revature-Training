package com.revature.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        // load the Spring configuration file
        ApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
        // retrieve bean from Spring container
        MessageServce myMsg = context.getBean("messageService", MessageServce.class);

        myMsg.printMessage();

        
    }
}