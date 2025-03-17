package com.java.reactive.day11_Sinks;

import com.java.reactive.utils.Singleton;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

//unicast indicate One pub and one sub
public class S2Sink_Unicast {
    public static void main(String[] args) {
      Sinks.Many<Object> sink= Sinks.many().unicast().onBackpressureBuffer();//protect when pub produce many dat
      Flux<Object> flux=sink.asFlux();

      flux.subscribe(Singleton.subscriber("Dara"));
      //flux.subscribe(Singleton.subscriber("hey!"));//error

      sink.tryEmitNext("Hi Guy!");
      sink.tryEmitNext("Welcome to Flux!");
      sink.tryEmitNext("Nice to meet you!");
    }
}
