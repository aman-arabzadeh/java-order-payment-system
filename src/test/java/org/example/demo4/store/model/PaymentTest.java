package org.example.demo4.store.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PaymentTest {

    @Test
    void newPaymentShouldHavePendingStatusAndCorrectFields() {
        var payment = new Payment("order123", new BigDecimal("75"));
        assertNotNull(payment.getId());
        assertEquals("order123", payment.getOrderId());
        assertEquals(new BigDecimal("75"), payment.getAmount());
        assertEquals(PaymentStatus.PENDING, payment.getStatus());
    }

    @Test
    void setStatusShouldUpdateStatus() {
        var payment = new Payment("order123", new BigDecimal("75"));
        payment.setStatus(PaymentStatus.SUCCESS);
        assertEquals(PaymentStatus.SUCCESS, payment.getStatus());
    }

    @Test
    void eachPaymentShouldHaveUniqueId() {
        var payment1 = new Payment("order1", new BigDecimal("10"));
        var payment2 = new Payment("order2", new BigDecimal("20"));
        assertNotEquals(payment1.getId(), payment2.getId());
    }

    @Test
    void nullOrderIdShouldBeAccepted() {
        var payment = new Payment(null, new BigDecimal("15"));
        assertNull(payment.getOrderId());
    }

    @Test
    void nullAmountShouldBeAccepted() {
        var payment = new Payment("order789", null);
        assertNull(payment.getAmount());
    }
}