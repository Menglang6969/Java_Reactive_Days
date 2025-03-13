package com.java.reactive.day10_Repeat_Retry;

import com.java.reactive.utils.Singleton;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

public class FluxRepeat {
    private static AtomicInteger atomic = new AtomicInteger(0);

    public static void main(String[] args) {
        flux()
                //.repeat(2) // repeat 2times after completed
                .repeat(()->atomic.get()<19)
                .subscribe(Singleton.subscriber(""));
    }
    public static Flux<Integer> flux() {
        return Flux.range(1,3)
                .doOnSubscribe(x->System.out.println("Subscribed... "))
                .doOnComplete(()->System.out.println("Completed..."))
                .map(x->atomic.incrementAndGet())

                ;
        }
}
