package com.java.reactive.day11_Sinks;

import com.java.reactive.utils.Singleton;
import com.java.reactive.utils.Utils;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

public class S4SinksHandleFailer {
    public static void main(String[] args) {
       Sinks.One<Object> sink= Sinks.one();// sink handle as publisher
       Mono<Object> mono= sink.asMono();// mono handle with subscriber

        mono.subscribe(Singleton.subscriber("Menglang"));

        sink.tryEmitValue("eh");

        sink.emitValue("Hello Black Friday",((signalType, emitResult) -> {
            System.out.println("signalType: " + signalType);
            System.out.println("emitResult: " + emitResult);
            return false;
        }));



        Utils.delay(20);
    }
}
