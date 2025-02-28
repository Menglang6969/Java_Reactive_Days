package com.java.reactive.day1;

import com.github.javafaker.Faker;
import com.java.reactive.utils.Utils;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

//** pipline mean (). and next ().
public class PipLineDemo {
    public static void main(String[] args) {
        //** if we want to these three methods to execute parallel at the same time
        //that mean one the 2,3 calling no need to wait for 1 calling finish to execute
        getName();
        getName()
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe(Utils.onNext(), Utils.onError(), Utils.onComplete());
        getName();
        Utils.delay(4);
    }

    private static Mono<String> getName() {
        System.out.println("Execute Method....");
        return Mono.fromSupplier(() -> {
            System.out.println("Generate country....");
            Utils.delay(3);
            return Faker.instance().country().name();
        }).map(x -> x.toUpperCase());
    }



}
