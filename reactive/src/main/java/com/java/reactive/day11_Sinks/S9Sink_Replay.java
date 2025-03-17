package com.java.reactive.day11_Sinks;

import com.java.reactive.utils.Singleton;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

//replay indicate replay of all values for late subscriber
public class S9Sink_Replay {
    public static void main(String[] args) {
        Sinks.Many<Object> sink = Sinks.many().replay().all();//cache history message
        Flux<Object> flux = sink.asFlux();
        sink.tryEmitNext("Hi Guy!");
        sink.tryEmitNext("Welcome to Flux!");


        flux.subscribe(Singleton.subscriber("Dara"));
        flux.subscribe(Singleton.subscriber("Roth!"));


        sink.tryEmitNext("Thank U!");
        sink.tryEmitNext("Guy......!");

        flux.subscribe(Singleton.subscriber("Ra!"));
    }
}
