package com.revature.spring.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // This annotation registers the class as a Spring bean
public class BookService {
    private PaymentService paymentService;
    private InvoiceService invoiceService;

    @Autowired // Constructor injection of dependencies
    public BookService(PaymentService paymentService, InvoiceService invoiceService) {
        this.paymentService = paymentService;
        this.invoiceService = invoiceService;
    }

    public void purchaseBook() {
        System.out.println("Book Purchased Starting...");
        paymentService.processPayment();
        invoiceService.generateInvoice();
        System.out.println("Book Purchase Completed");
    }
}
