package com.revature.spring.payment;

import org.springframework.stereotype.Component;

@Component("creditCardPaymentMethod") // This annotation registers the class as a Spring bean with the specified name
public class CreditCardPaymentMethod implements Payment {
    @Override
    public void pay() {
        System.out.println("This is the Credit Card payment method");
    }

}
