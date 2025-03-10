package com.java.reactive.day7_BackPresure;

import com.java.reactive.utils.Singleton;
import com.java.reactive.utils.Utils;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.List;

public class BP4_Overflow_CaptureDropValue {
    public static void main(String[] args) {

        List<Object> dropValue=new ArrayList<>();
        System.setProperty("reactor.bufferSize.small", "16");
        //75% of 16 is 12. after Received 12, it keep 1 latest pushed 293 then it wil receive 293

        Flux.create(sink -> {
                    for(int i=1; i<=500; i++){
                        System.out.println("Pushed: "+i);
                        sink.next(i);
                        Utils.sleep(3);
                    }
                    sink.complete();
                })
                .onBackpressureDrop(dropValue::add)

                .publishOn(Schedulers.boundedElastic())
                .doOnNext(x->{
                    //process to consume like write data to db or process something...
                    Utils.sleep(100);
                })
                .subscribe(Singleton.subscriber("Received "));
        System.out.println(dropValue);
        Utils.delay(10);//block main thread for 10s to not run next task

    }
}
