package com.java.reactive.day11_Sinks;

import com.java.reactive.utils.Singleton;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

//multicast indicate One pub and many sub
public class S6Sink_Multicast {
    public static void main(String[] args) {
        Sinks.Many<Object> sink = Sinks.many().multicast().onBackpressureBuffer();//protect when pub produce many dat
        Flux<Object> flux = sink.asFlux();
        sink.tryEmitNext("Hi Guy!");
        sink.tryEmitNext("Welcome to Flux!");


        flux.subscribe(Singleton.subscriber("Dara"));
        flux.subscribe(Singleton.subscriber("hey!"));


        sink.tryEmitNext("Thank U!");
        sink.tryEmitNext("Guy......!");

        flux.subscribe(Singleton.subscriber("Hehhh!"));// the last subscribe has nothing to emmit
    }
}
