package com.java.reactive.day3;

import com.java.reactive.utils.Singleton;
import reactor.core.publisher.Flux;

public class ShareThread {
    public static void main(String[] args) {
        ColorProducer cp = new ColorProducer();

        Flux.create(cp)
                .subscribe(Singleton.subscriber("Lang001"));
        cp.product();

        Runnable runnable = ()->cp.product();
        for (int i=0; i<10; i++){
            Thread thread=new Thread(runnable);
            thread.start();
        }
    }
}
