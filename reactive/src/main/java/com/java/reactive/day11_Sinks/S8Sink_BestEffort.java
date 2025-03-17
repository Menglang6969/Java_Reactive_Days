package com.java.reactive.day11_Sinks;

import com.java.reactive.utils.Singleton;
import com.java.reactive.utils.Utils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.time.Duration;

//multicast indicate One pub and many sub
public class S8Sink_BestEffort {
    public static void main(String[] args) {
//        Sinks.Many<Object> sink = Sinks.many().multicast().directAllOrNothing();//if one subscribe slow it effect to another sub
        Sinks.Many<Object> sink = Sinks.many().multicast().directBestEffort();//if one subscribe slow not effect another subscriber
        Flux<Object> flux = sink.asFlux();

        flux.subscribe(Singleton.subscriber("Dara"));
        flux.delayElements(Duration.ofMillis(100)).subscribe(Singleton.subscriber("Roth"));

        for(int i=1;i<100; i++){
            sink.tryEmitNext(i);
        }


        Utils.delay(50);
    }
}
