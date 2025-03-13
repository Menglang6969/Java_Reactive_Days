package com.java.reactive.day9_Batching;

import com.java.reactive.utils.Singleton;
import com.java.reactive.utils.Utils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.GroupedFlux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

public class B3_GroupBy {
    private static final AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {


       // window return as flux
        // buffer return collection items as list
        // group by properties
        fluxStream()
                .groupBy(x->x%2)
                //  .doOnNext(flux->saveItems(flux))
                .subscribe(gf->processItem(gf,gf.key()));

        Utils.delay(10);
    }

    public static Flux<Integer> fluxStream() {
        return Flux.range(1,30)
                .delayElements(Duration.ofSeconds(1));
    }

    public static void processItem(Flux<Integer> flux,Integer key) {
       flux.subscribe(x->System.out.println("item: "+x+" Key: "+key));
    }

}
