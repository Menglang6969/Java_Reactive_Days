package com.java.reactive.day5_Operator;

import com.java.reactive.utils.Singleton;
import reactor.core.publisher.Flux;

public class DefaultEmpty {

    public static void main(String[] args) {
            getNumbers()
                    .filter(x->x>8)
                    .defaultIfEmpty(1)
                    .subscribe(Singleton.subscriber(""));
    }
    private static Flux<Integer> getNumbers() {
        return Flux.range(1, 10);
    }
}
