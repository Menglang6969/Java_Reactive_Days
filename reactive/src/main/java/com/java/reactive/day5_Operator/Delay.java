package com.java.reactive.day5_Operator;

import com.java.reactive.utils.Singleton;
import com.java.reactive.utils.Utils;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Delay {
    public static void main(String[] args) {

        Flux.create(sink -> {
            for (int i = 1; i <= 100; i++) {
                sink.next(i);
            }
        })
                .log()
                .delayElements(Duration.ofSeconds(1))
                .subscribe(Singleton.subscriber(""));

        Utils.delay(30);
    }
}
