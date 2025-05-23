package org.example.demo4.store.model;

import java.math.BigDecimal;


public record CardGame(String name, BigDecimal price) implements Game {
}

