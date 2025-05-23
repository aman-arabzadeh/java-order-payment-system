package org.example.demo4.store.model.service;

import org.example.demo4.store.model.Order;
import org.example.demo4.store.model.OrderStatus;
import org.example.demo4.store.model.Payment;
import org.example.demo4.store.model.PaymentStatus;


public class PaymentService {
    public void processPayment(Order order, Payment payment) {
        if (payment.getAmount().compareTo(order.calculateTotal()) == 0) {
            payment.setStatus(PaymentStatus.SUCCESS);
            order.setStatus(OrderStatus.PAID);
        } else {
            payment.setStatus(PaymentStatus.FAILED);
        }
    }
}