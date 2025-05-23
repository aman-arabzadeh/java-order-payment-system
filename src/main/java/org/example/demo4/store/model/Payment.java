package org.example.demo4.store.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
public class Payment {
    private final String id = UUID.randomUUID().toString();
    private final String orderId;
    private final BigDecimal amount;

    @Setter
    private PaymentStatus status = PaymentStatus.PENDING;

    public Payment(String orderId, BigDecimal amount) {
        this.orderId = orderId;
        this.amount = amount;
    }
}
