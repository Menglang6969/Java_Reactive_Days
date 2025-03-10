package com.java.reactive.day3;

import com.java.reactive.utils.Singleton;
import reactor.core.publisher.Flux;

public class CreateMethod {
    public static void main(String[] args) {
//        Flux.create(fluxSink->{
//           fluxSink.next("Hello 1");
//        }).subscribe(Singleton.subscriber("Lang003"));


       /* Flux.create(fluxSink->{
            String color;
            do{
                color=Singleton.faker().color().name();
                fluxSink.next(color);
            }while(!color.equals("red"));
            fluxSink.complete();
        }).subscribe(Singleton.subscriber("Color-"));
   */
        ColorProducer cp = new ColorProducer();
         Flux.create(cp)
                .subscribe(Singleton.subscriber("Lang009-"));
         cp.product();
    }
}
