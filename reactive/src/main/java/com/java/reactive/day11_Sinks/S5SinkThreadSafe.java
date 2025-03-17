package com.java.reactive.day11_Sinks;

import com.java.reactive.utils.Utils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class S5SinkThreadSafe {
    public static void main(String[] args) {


        Sinks.Many<Object> sink = Sinks.many().unicast().onBackpressureBuffer();

        //flux use by subscriber
        Flux<Object> flux = sink.asFlux();
        List<Object> list = new ArrayList<>();

        flux.subscribe(list::add);

        for (int i = 0; i < 100; i++) {
            int finalI = i;
            CompletableFuture.runAsync(() -> {
//                sink.tryEmitNext(finalI);
                sink.emitNext(finalI, (s, e) -> true); //thread safe
            });
        }

        Utils.delay(5);
        System.out.println(list.size());
    }
}
