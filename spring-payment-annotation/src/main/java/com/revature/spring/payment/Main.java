package com.revature.spring.payment;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.revature.spring.payment") // This annotation tells Spring to scan the specified package for components
public class Main {
    public static void main(String[] args) {
        // load the Spring configuration from annotations
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        // retrieve bean from Spring container
        PaymentProcessor processor = context.getBean(PaymentProcessor.class);

        // Call method on the bean
        processor.processPayment();

        ((AnnotationConfigApplicationContext) context).close();
    }
}