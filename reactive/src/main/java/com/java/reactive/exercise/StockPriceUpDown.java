package com.java.reactive.exercise;

import com.github.javafaker.Faker;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

public class StockPriceUpDown {
    private final AtomicInteger atomicInteger = new AtomicInteger(100);

    public Flux<Integer> getPrice() {

        return Flux.interval(Duration.ofSeconds(1)).map(i -> atomicInteger.accumulateAndGet((Faker.instance().random().nextInt(-3, 3)), (a, b) -> a + b));
    }

}
