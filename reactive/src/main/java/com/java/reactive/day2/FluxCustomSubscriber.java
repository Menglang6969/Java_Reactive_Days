package com.java.reactive.day2;

import com.java.reactive.utils.Utils;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicReference;

public class FluxCustomSubscriber {
    public static void main(String[] args) {
        Flux<Integer> flux = Flux.range(1,  10);

        AtomicReference<Subscription> ref=new AtomicReference<>();
        flux.subscribeWith(new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription subscription) {
                System.out.println("On Subscribed: "+subscription.toString());
                ref.set(subscription);
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("On Next: " + integer);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("On Error: " + throwable.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("On Complete");
            }
        });

        ref.get().request(4);
        Utils.delay(4);
        ref.get().request(3);
        ref.get().cancel();
        ref.get().request(2);
        ref.get().request(1);
    }
}
