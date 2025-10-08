package com.revature.spring.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component // This annotation registers the class as a Spring bean
public class PaymentProcessor {

    // CONSTRUCTOR INJECTION OF DEPENDENCY
    private Payment paymentMethod;
    /* 
        You can switch between Paypal and CreditCard by changing the qualifier value
        public PaymentProcessor(@Qualifier("payPalPaymentMethod") Payment paymentMethod)
    */ 
    
    @Autowired 
    public PaymentProcessor(@Qualifier("creditCardPaymentMethod") Payment paymentMethod) {
        this.paymentMethod = paymentMethod; 
    }

    /*
        // SETTER INJECTION OF DEPENDENCY
        @Autowired
        @Qualifier("creditCardPaymentMethod") // This annotation specifies which bean to inject when multiple candidates are available
        public void setPaymentMethod(Payment paymentMethod) {
            this.paymentMethod = paymentMethod;
        }
    */

    /*
     // FIELD INJECTION OF DEPENDENCY
        @Autowired
        @Qualifier("creditCardPaymentMethod") // This annotation specifies which bean to inject when multiple candidates are available
        private Payment paymentMethod;
    */

    public void processPayment() {
        paymentMethod.pay();
    }
}
