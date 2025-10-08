package com.revature.spring.bookstore;

import org.springframework.stereotype.Component;

@Component // This annotation registers the class as a Spring bean
public class InvoiceService {
    
    public void generateInvoice() {
        System.out.println("Invoice Generated Successfully");
    }
}
