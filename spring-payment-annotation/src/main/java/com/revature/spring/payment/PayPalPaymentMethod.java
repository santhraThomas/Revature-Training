package com.revature.spring.payment;

import org.springframework.stereotype.Component;

@Component("paypalPaymentMethod") // This annotation registers the class as a Spring bean with the name "paypalPaymentMethod"
public class PayPalPaymentMethod implements Payment {
    @Override
    public void pay() {
        System.out.println("This is the PayPal payment method");
    }

}
