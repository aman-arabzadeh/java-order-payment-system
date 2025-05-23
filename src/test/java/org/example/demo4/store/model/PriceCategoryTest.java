package org.example.demo4.store.model;

import org.example.demo4.store.PriceCategory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class PriceCategoryTest {
    @Test
    void priceValuesShouldMatchExpectedTiers() {
        assertEquals(new BigDecimal("20"), PriceCategory.BASIC.getPrice());
        assertEquals(new BigDecimal("50"), PriceCategory.STANDARD.getPrice());
        assertEquals(new BigDecimal("150"), PriceCategory.PREMIUM.getPrice());
    }
}
