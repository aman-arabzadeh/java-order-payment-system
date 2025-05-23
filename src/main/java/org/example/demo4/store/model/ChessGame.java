package org.example.demo4.store.model;

import org.example.demo4.store.PriceCategory;

import java.math.BigDecimal;


public class ChessGame implements Game {

    private final PriceCategory category;

    public ChessGame(PriceCategory category) {
        this.category = category;
    }

    @Override
    public String name() {
        return "Chess Set (" + category.name() + ")";
    }

    @Override
    public BigDecimal price() {
        return category.getPrice();
    }
}