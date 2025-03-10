package com.java.reactive.day6_DefaultThread;

import reactor.core.publisher.Flux;

public class DefaultThread {

    public static void main(String[] args) {
//        Flux.create(sink->{
//            printThreadName("create");
//            sink.next(10);
//
//        }).doOnNext(x->printThreadName("doOnNext "+x))
//                .subscribe(x->printThreadName("subscribe: "+x));
//

       Flux<Object> flux= Flux.create(sink->{
                    printThreadName("create");
                    sink.next(10);

                }).doOnNext(x->printThreadName("doOnNext "+x));

     //  flux.subscribe(x->printThreadName("subscribe: "+x));


       Runnable runnable=()->flux.subscribe(x->printThreadName("subscribe: "+x));
       for(int i=0;i<2;i++){
           new Thread(runnable).start();
       }
    }

    public static void printThreadName(String text){
        System.out.println(text+": "+Thread.currentThread().getName());
    }

}
