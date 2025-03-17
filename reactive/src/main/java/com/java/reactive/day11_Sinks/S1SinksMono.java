package com.java.reactive.day11_Sinks;

import com.java.reactive.utils.Singleton;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;


/*
Sink Type
* Type: behavior: pub:sub
- one: Mono :1:N //1 publisher can have many subscriber
- Many-unicast: Flux: 1:1
- Many-replay: Flux 1:N(With replay of all values for late subscriber)


 */

public class S1SinksMono {
    public static void main(String[] args) {
       Sinks.One<Object> sink= Sinks.one();// sink handle as publisher
       Mono<Object> mono= sink.asMono();// mono handle with subscriber

        mono.subscribe(Singleton.subscriber("Menglang"));
        mono.subscribe(Singleton.subscriber("JingLong"));
        sink.tryEmitValue("hello");
        sink.tryEmitValue("what's up");
    }
}
