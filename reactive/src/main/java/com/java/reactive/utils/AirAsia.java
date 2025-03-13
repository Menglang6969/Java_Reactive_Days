package com.java.reactive.utils;

import reactor.core.publisher.Flux;

import java.time.Duration;

public class AirAsia {
    public static Flux<String> getFlight() {
        return Flux.range(1, Singleton.faker().random().nextInt(1, 5))
                .map(x -> "AirAsia: " + Singleton.faker().random().nextInt(700, 1000))
                .delayElements(Duration.ofSeconds(1));
    }
}
