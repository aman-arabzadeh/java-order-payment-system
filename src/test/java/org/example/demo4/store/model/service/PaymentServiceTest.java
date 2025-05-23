package org.example.demo4.store.model.service;

import org.example.demo4.store.model.Order;
import org.example.demo4.store.model.OrderStatus;
import org.example.demo4.store.model.Payment;
import org.example.demo4.store.model.PaymentStatus;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PaymentServiceTest {
    @Mock
    private Order order;

    @Mock
    private Payment payment;

    @InjectMocks
    private PaymentService sut;

    @Test
    void processPaymentShouldSetSuccessAndPaidWhenAmountsMatch() {
        when(payment.getAmount()).thenReturn(new BigDecimal("100"));
        when(order.calculateTotal()).thenReturn(new BigDecimal("100"));

        sut.processPayment(order, payment);

        verify(payment).setStatus(PaymentStatus.SUCCESS);
        verify(order).setStatus(OrderStatus.PAID);
    }

    @Test
    void processPaymentShouldSetFailedWhenAmountsDoNotMatch() {
        when(payment.getAmount()).thenReturn(new BigDecimal("50"));
        when(order.calculateTotal()).thenReturn(new BigDecimal("100"));

        sut.processPayment(order, payment);

        verify(payment).setStatus(PaymentStatus.FAILED);
        verify(order, never()).setStatus(any());
    }

    @Test
    void processPaymentShouldThrowWhenAmountIsNull() {
        when(payment.getAmount()).thenReturn(null);
        when(order.calculateTotal()).thenReturn(BigDecimal.TEN);

        assertThrows(NullPointerException.class, () -> sut.processPayment(order, payment));
    }

    @Test
    void processPaymentShouldSucceedWhenAmountIsZeroAndTotalIsZero() {
        when(payment.getAmount()).thenReturn(BigDecimal.ZERO);
        when(order.calculateTotal()).thenReturn(BigDecimal.ZERO);

        sut.processPayment(order, payment);

        verify(payment).setStatus(PaymentStatus.SUCCESS);
        verify(order).setStatus(OrderStatus.PAID);
    }
}
