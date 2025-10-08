package com.revature.spring.bookstore;
import org.springframework.stereotype.Component;

@Component // This annotation registers the class as a Spring bean
public class PaymentService {

    public void processPayment() {
        System.out.println("Payment Proccessed Successfully");
    }

}
