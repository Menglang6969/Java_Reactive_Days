package com.java.reactive.day5_Operator;

import com.java.reactive.utils.Singleton;
import reactor.core.publisher.Flux;

public class LimitRate {

    public static void main(String[] args) {
        Flux.create(sink->{
            for (int i = 1; i <= 100; i++) {
                sink.next(i);
            }
        })
                .log()
                .limitRate(10,0)//highTide 10 each request,lowTide (0) but if low(1) fetch 75%
                .subscribe(Singleton.subscriber(""));
    }
}
