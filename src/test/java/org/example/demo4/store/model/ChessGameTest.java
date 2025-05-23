package org.example.demo4.store.model;

import org.example.demo4.store.PriceCategory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

class ChessGameTest {

    @ParameterizedTest
    @EnumSource(PriceCategory.class)
    void nameShouldIncludeCategory(PriceCategory category) {
        var game = new ChessGame(category);
        assertTrue(game.name().contains(category.name()));
        assertTrue(game.name().startsWith("Chess Set"));
    }

    @Test
    void priceShouldMatchCategoryValues() {
        var basic = new ChessGame(PriceCategory.BASIC);
        assertEquals(new BigDecimal("20"), basic.price());

        var standard = new ChessGame(PriceCategory.STANDARD);
        assertEquals(new BigDecimal("50"), standard.price());

        var premium = new ChessGame(PriceCategory.PREMIUM);
        assertEquals(new BigDecimal("150"), premium.price());
    }
}
