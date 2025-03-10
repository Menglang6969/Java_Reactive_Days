package com.java.reactive.day6_DefaultThread;

import com.java.reactive.utils.Utils;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class MultiSubscribeOn {
    public static void main(String[] args) {
      Flux<Object> flux=  Flux.create(fluxSink -> {
            printTheadName("create: ");
            fluxSink.next("10");
        })
              .subscribeOn(Schedulers.newParallel("Menglang"))
              .doOnNext(x->printTheadName("Next: "+x));


      flux
              .doFirst(()->printTheadName("doFirst2: "))
              .subscribeOn(Schedulers.boundedElastic())
              .doFirst(()->printTheadName("Do first1"))
              .subscribe(x->printTheadName("sub: "));



//        Runnable runnable=()-> flux.doFirst(()->printTheadName("doFirst2: "))
//                .subscribeOn(Schedulers.boundedElastic())
//                .doFirst(()->printTheadName("Do first1"))
//                .subscribe(x->printTheadName("sub: "));;
////
//        for(int i=0;i<2;i++){
//            new Thread(runnable).start();
//        }
        Utils.delay(60);

    }



    private static void printTheadName(String text) {

        System.out.println(text+": "+Thread.currentThread().getName());
    }
}
