package org.example.demo4.store;

import java.math.BigDecimal;


public enum PriceCategory {
    BASIC(new BigDecimal("20")),
    STANDARD(new BigDecimal("50")),
    PREMIUM(new BigDecimal("150"));

    private final BigDecimal price;

    PriceCategory(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
