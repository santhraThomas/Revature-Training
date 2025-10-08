package com.revature.spring.payment;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        // load the Spring configuration file
        ApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");

        // retrieve bean from Spring container
        PaymentProcessor processor = context.getBean("paymentProcessor", PaymentProcessor.class);

        // Call method on the bean
        processor.processPayment();

        ((ClassPathXmlApplicationContext) context).close();
    }
}