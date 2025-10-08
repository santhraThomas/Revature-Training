package com.revature.spring.payment;

public class PayPalPaymentMethod implements Payment {
    @Override
    public void pay() {
        System.out.println("This is the PayPal payment method");
    }
}
