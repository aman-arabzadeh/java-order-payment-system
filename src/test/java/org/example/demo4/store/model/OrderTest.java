package org.example.demo4.store.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderTest {
    @InjectMocks
    private Order sut;

    @Test
    void newOrderShouldHaveCreatedStatusAndNoItems() {
        assertEquals(OrderStatus.CREATED, sut.getStatus());
        assertTrue(sut.getItems().isEmpty());
    }

    @Test
    void addItemAndCalculateTotal() {
        var game1 = mock(Game.class);
        when(game1.price()).thenReturn(new BigDecimal("20"));
        var game2 = mock(Game.class);
        when(game2.price()).thenReturn(new BigDecimal("30"));

        sut.addItem(game1);
        sut.addItem(game2);

        var total = sut.calculateTotal();
        assertEquals(new BigDecimal("50"), total);
    }

    @Test
    void addItemWhenNotCreatedShouldThrow() {
        sut.setStatus(OrderStatus.PAID);
        var game = mock(Game.class);

        var ex = assertThrows(
                IllegalStateException.class,
                () -> sut.addItem(game)
        );
        assertEquals("Can only add items to a CREATED order", ex.getMessage());
    }
}
