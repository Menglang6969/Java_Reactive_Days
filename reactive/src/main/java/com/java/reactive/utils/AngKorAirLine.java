package com.java.reactive.utils;

import reactor.core.publisher.Flux;

import java.time.Duration;

public class AngKorAirLine {
    public static Flux<String> getFlight() {
        return Flux.range(1, Singleton.faker().random().nextInt(1, 5))
                .map(x -> "AngkorAirLine: " + Singleton.faker().random().nextInt(700, 1000))
                .delayElements(Duration.ofSeconds(1));
    }
}
