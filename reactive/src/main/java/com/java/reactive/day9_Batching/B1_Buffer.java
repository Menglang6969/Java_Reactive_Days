package com.java.reactive.day9_Batching;

import com.java.reactive.utils.Singleton;
import com.java.reactive.utils.Utils;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class B1_Buffer {
    public  static void main(String[] args) {

        fluxStream()
//                .buffer(10) //amount of item
//                .buffer(Duration.ofSeconds(3))//emit every  3seconds
                .bufferTimeout(20,Duration.ofSeconds(3))
                .subscribe(Singleton.subscriber(""));
        ;

        Utils.delay(50);
    }

    public static Flux<String> fluxStream(){
        Flux<String> fluxStream = Flux.interval(Duration.ofMillis(300))
                .map(x->"event"+x);
        return fluxStream;
    }
}
