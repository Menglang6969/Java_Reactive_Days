package com.java.reactive.day2;

import reactor.core.publisher.Flux;

public class FluxLog {
    public static void main(String[] args) {
        Flux<Integer> flux = Flux.range(1, 10);
        flux.filter(x -> x % 2 == 0).log().map(x -> x * 2).subscribe(x -> System.out.println("value: " + x));

    }
}
