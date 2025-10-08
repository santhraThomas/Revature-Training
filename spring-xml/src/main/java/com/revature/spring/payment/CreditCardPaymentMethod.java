package com.revature.spring.payment;

public class CreditCardPaymentMethod implements Payment {
    @Override
    public void pay() {
        System.out.println("This is the Credit Card payment method");
    }

}
