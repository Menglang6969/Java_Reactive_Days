package com.java.reactive.day1;

import com.java.reactive.utils.Utils;
import reactor.core.publisher.Mono;

public class Day1 {
    public static void main() {
        System.out.println("Hello World");
    }

    public Mono<String> demoMono() {
        //default lazy (subscribe then invoke)
        //Mono Publisher or Emit
        Mono<String> mono = Mono.just("Hello Mono Reactive");

        //Mono Subscriber
//        mono.subscribe(onNext,onError,Runnable);
        mono.subscribe(Utils.onNext(), Utils.onError(), Utils.onComplete());

        return mono;
    }
}
