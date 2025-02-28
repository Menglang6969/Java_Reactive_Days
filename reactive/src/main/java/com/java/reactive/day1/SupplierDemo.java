package com.java.reactive.day1;

import com.github.javafaker.Faker;
import com.java.reactive.utils.Utils;
import reactor.core.publisher.Mono;

public class SupplierDemo {
    public static void main(String[] args) {

        //we use just method only when we've already have data
       // Mono<String> mono = Mono.just(getName());


        //** we use fromSupplier for Lazy Execute
        Mono<String> monoSupplier=  Mono.fromSupplier(() -> getName());
        //** it call method getName when subscribe
        monoSupplier.subscribe(Utils.onNext(),Utils.onError(),Utils.onComplete());


    }
    private static String getName(){
        System.out.println("Generate name....");
        return Faker.instance().funnyName().name();
    }
}
