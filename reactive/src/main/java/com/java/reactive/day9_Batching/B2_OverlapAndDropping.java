package com.java.reactive.day9_Batching;

import com.java.reactive.utils.Singleton;
import com.java.reactive.utils.Utils;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class B2_OverlapAndDropping {
    public  static void main(String[] args) {

        fluxStream()
                .buffer(5,2) //amount of item wait to emit
//                .buffer(Duration.ofSeconds(3))//emit every  3seconds

                .subscribe(Singleton.subscriber(""));
        ;

        Utils.delay(10);
    }

    public static Flux<String> fluxStream(){
        Flux<String> fluxStream = Flux.interval(Duration.ofMillis(300))
                .map(x->"event"+x);
        return fluxStream;
    }
}
