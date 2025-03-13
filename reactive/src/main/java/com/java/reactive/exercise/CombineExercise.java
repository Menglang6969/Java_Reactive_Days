package com.java.reactive.exercise;

import com.java.reactive.utils.Singleton;
import com.java.reactive.utils.Utils;
import reactor.core.publisher.Flux;

import java.nio.DoubleBuffer;
import java.time.Duration;

public class CombineExercise {
    public static void main(String[] args) {

        double carPrice=10000.00;

        Flux.combineLatest(monthStream(),demandStream(),(month,demand)->{
            return (carPrice - month*100)*demand;
        })
                .take(12)
                .subscribe(Singleton.subscriber("Price:"));

        Utils.delay(60);
    }

    private static Flux<Long> monthStream(){
        return Flux.interval(Duration.ZERO, Duration.ofSeconds(1));
    }

    private static Flux<Double> demandStream(){
        return Flux.interval( Duration.ofSeconds(2))
                .map(l -> Singleton.faker().random().nextInt(8,12)/10.0)
                .startWith(1.0)
                .doOnNext(System.out::println);
    }
}
