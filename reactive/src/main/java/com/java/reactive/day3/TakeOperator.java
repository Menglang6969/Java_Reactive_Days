package com.java.reactive.day3;

import com.java.reactive.utils.Singleton;
import reactor.core.publisher.Flux;

public class TakeOperator {
    public static void main(String[] args) {
        Flux.range(1,10)
                .take(5)
                .log()
                .subscribe(Singleton.subscriber("Mr.lang"));
    }
}
