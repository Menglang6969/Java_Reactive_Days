package com.java.reactive.service;

import com.java.reactive.utils.PurchaseOrder;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class RevenueService {

    private final Map<String, Double> db = new HashMap<>();

    public RevenueService() {
        db.put("Kids", 0.0);
        db.put("Clothing", 0.0);
    }

    public Consumer<PurchaseOrder> consumeOrderStreaming() {
        return p -> db.computeIfPresent(p.getCategory(), (k, v) -> v + p.getPrice());
    }

    public Flux<String> getRevenue() {
      return Flux.interval(Duration.ofSeconds(2)).map(x -> db.toString());
    }
}
