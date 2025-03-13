package com.java.reactive.day10_Repeat_Retry;

import com.java.reactive.utils.Singleton;
import com.java.reactive.utils.Utils;
import reactor.core.publisher.Flux;
import reactor.util.retry.Retry;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

public class FluxRetry {
    private static AtomicInteger atomic = new AtomicInteger(0);

    public static void main(String[] args) {
        flux()
             //   .retry(2)
                .retryWhen(Retry.fixedDelay(2, Duration.ofSeconds(2)))
                .subscribe(Singleton.subscriber(""));

        Utils.delay(30);
    }
    public static Flux<Integer> flux() {
        return Flux.range(1,3)
                .doOnSubscribe(x->System.out.println("Subscribed... "))
                .doOnComplete(()->System.out.println("Completed..."))
                .map(x->atomic.incrementAndGet())
                .map(x->x/(Singleton.faker().random().nextInt(1,4)<3?0:1))
                .doOnError(x->System.out.println(x.getMessage()));
        }
}
