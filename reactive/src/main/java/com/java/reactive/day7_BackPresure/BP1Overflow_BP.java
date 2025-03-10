package com.java.reactive.day7_BackPresure;

import com.java.reactive.utils.Singleton;
import com.java.reactive.utils.Utils;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class BP1Overflow_BP {
    //when publisher produce data larger than subscriber (produce 1000/s , receive 100/s)
    public static void main(String[] args) {

        Flux.create(sink -> {

            for(int i=0; i<500; i++){
                System.out.println("Pushed: "+i);
                sink.next(i);
            }
            sink.complete();
        })
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(x->{
                    //process to consume like write data to db or process something...
                    Utils.sleep(100);
                })
                .subscribe(Singleton.subscriber(""));
        Utils.delay(50);
    }
}
