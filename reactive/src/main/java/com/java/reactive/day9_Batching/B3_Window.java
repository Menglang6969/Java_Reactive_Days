package com.java.reactive.day9_Batching;

import com.java.reactive.utils.Singleton;
import com.java.reactive.utils.Utils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

public class B3_Window {
    private static final AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {


       // window return as flux
        // buffer return as list
        fluxStream()
                .window(5)
                .flatMap(flux -> saveItems(flux))
                //  .doOnNext(flux->saveItems(flux))
                .subscribe(Singleton.subscriber(""));

        Utils.delay(10);
    }

    public static Flux<String> fluxStream() {
        Flux<String> fluxStream = Flux.interval(Duration.ofMillis(300)).map(x -> "event" + x);
        return fluxStream;
    }

    public static Mono<Integer> saveItems(Flux<String> flux) {
        return flux
                .doOnNext(x -> System.out.println("Saving: " + x))
                .doOnComplete(() -> System.out.println("Items Saved"))
                .then(Mono.just(count.getAndIncrement()));
    }
}
