package com.java.reactive.day8_combine_publisher;

import com.java.reactive.utils.Singleton;
import com.java.reactive.utils.Utils;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class CombinePublisher_CombineLatest {
    public static void main(String[] args) {
        Flux.combineLatest(stringStream(),integerStream(),(s,i)->s+i)
                .subscribe(Singleton.subscriber(""));

        Utils.delay(30);
    }

    private static Flux<String> stringStream() {
        return Flux.just("A", "B", "C","D")
                .doOnNext(s -> System.out.println(" String "+s + " "))
                .delayElements(Duration.ofSeconds(1));

    }

    private static Flux<Integer> integerStream() {
        return Flux.just(1, 2, 3,4,5,6,7)

                .delayElements(Duration.ofSeconds(3))
                .doOnNext(s -> System.out.println(" Integer "+s + " "))
                ;
    }
}

