package com.revature.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        // load the Spring configuration file
        ApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
        // retrieve bean from Spring container
        MessageServce myMsg = context.getBean("messageService", MessageServce.class);
        // Call method on the bean
        myMsg.printMessage();

        ((ClassPathXmlApplicationContext) context).close();
        
        /* MessageServce myMsg1 = context.getBean("messageService1", MessageServce.class);

        myMsg1.printMessage(); 
        
        */
        
    }
}