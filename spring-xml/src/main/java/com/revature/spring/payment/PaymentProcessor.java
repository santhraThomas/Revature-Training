package com.revature.spring.payment;

public class PaymentProcessor {
    // Dependency on the Payment interface
    private Payment paymentMethod;

    // Setter for dependency injection
    public void setPaymentMethod(Payment paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    // Method to process payment
    public void processPayment() {
        paymentMethod.pay();
    }

}
