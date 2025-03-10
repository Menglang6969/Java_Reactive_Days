package com.java.reactive.day5_Operator;

import com.java.reactive.utils.Singleton;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class OnError {
    public static void main(String[] args) {
//        Flux.range(1,10)
//                .map(i->10/(5-i))
////                .onErrorReturn(-1)
//                .onErrorResume((e)-> getFallback(e))
//                .subscribe(Singleton.subscriber(""));

        Flux.range(1,10)
                .map(i->10/(5-i))
                .onErrorContinue((e,obj)->{
                   System.out.println("Error "+obj+" e: "+e.getMessage());
                })
                .subscribe(Singleton.subscriber(""));
    }

    private static Mono<Integer> getFallback(Throwable throwable) {
        return Mono.fromSupplier(()->Singleton.faker().random().nextInt(10,999));
    }
}
