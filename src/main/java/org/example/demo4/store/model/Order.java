package org.example.demo4.store.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Getter
public class Order {
    private final String id = UUID.randomUUID().toString();

    private final List<Game> items = new ArrayList<>();

    @Setter
    private OrderStatus status = OrderStatus.CREATED;

    public List<Game> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void addItem(Game game) {
        if (status != OrderStatus.CREATED) {
            throw new IllegalStateException("Can only add items to a CREATED order");
        }
        items.add(game);
    }

    public BigDecimal calculateTotal() {
        return items.stream()
                .map(Game::price)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
