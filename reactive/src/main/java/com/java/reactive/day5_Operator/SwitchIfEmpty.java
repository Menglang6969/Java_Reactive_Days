package com.java.reactive.day5_Operator;

import com.java.reactive.utils.Singleton;
import reactor.core.publisher.Flux;

public class SwitchIfEmpty {

    public static void main(String[] args) {
        getNumbers()
                .filter(x->x>10)
                .switchIfEmpty(getNewNumber())
                .subscribe(Singleton.subscriber(""));
    }

    private static Flux<Integer> getNumbers(){
        return Flux.range(1, 10);
    }
    private static Flux<Integer> getNewNumber(){
        return Flux.range(555, 10);
    }
}
