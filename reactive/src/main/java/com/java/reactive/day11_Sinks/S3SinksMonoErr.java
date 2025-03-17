package com.java.reactive.day11_Sinks;

import com.java.reactive.utils.Singleton;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

public class S3SinksMonoErr {
    public static void main(String[] args) {
       Sinks.One<Object> sink= Sinks.one();// sink handle as publisher
       Mono<Object> mono= sink.asMono();// mono handle with subscriber

        mono.subscribe(Singleton.subscriber("Menglang"));
        sink.tryEmitError(new RuntimeException("err"));
       // mono.subscribe(Singleton.subscriber("JingLong"));
        //sink.tryEmitValue("hello");

       // sink.tryEmitValue("what's up");
    }
}
