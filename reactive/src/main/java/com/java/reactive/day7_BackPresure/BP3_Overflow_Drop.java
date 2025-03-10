package com.java.reactive.day7_BackPresure;

import com.java.reactive.utils.Singleton;
import com.java.reactive.utils.Utils;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class BP3_Overflow_Drop {
    public static void main(String[] args) {

        System.setProperty("reactor.bufferSize.small", "16");
        //75% of 16 is 12. after Received 12,pushed 302 then it wil receive 302

        Flux.create(sink -> {
                    for(int i=1; i<=500; i++){
                        System.out.println("Pushed: "+i);
                        sink.next(i);
                        Utils.sleep(3);
                    }
                    sink.complete();
                })
                .onBackpressureDrop()// once the queue is full new items will be dropped (prevent out of memory)
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(x->{
                    //process to consume like write data to db or process something...
                    Utils.sleep(100);
                })
                .subscribe(Singleton.subscriber("Received "));
        Utils.delay(10);//block main thread for 10s to not run next task
    }
}
