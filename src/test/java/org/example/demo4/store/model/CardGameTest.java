package org.example.demo4.store.model;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CardGameTest {
    @Test
    void nameAndPriceShouldBeReturnedCorrectly() {
        var card = new CardGame("Uno", new BigDecimal("5"));
        assertEquals("Uno", card.name());
        assertEquals(new BigDecimal("5"), card.price());
    }
}
