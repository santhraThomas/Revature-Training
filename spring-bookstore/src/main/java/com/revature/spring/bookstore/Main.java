package com.revature.spring.bookstore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.revature.spring.bookstore")
public class Main {
    public static void main(String[] args) {
        // load the Spring configuration from annotations
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        // retrieve bean from Spring container
        BookService bookService = context.getBean(BookService.class);

        // Call method on the bean
        bookService.purchaseBook();

        ((AnnotationConfigApplicationContext) context).close();
    }
}