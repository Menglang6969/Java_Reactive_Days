package com.java.reactive.day3;

import com.java.reactive.utils.DefaultSubscriber;
import com.java.reactive.utils.Singleton;
import reactor.core.publisher.Flux;

public class TestCustomSubscriber {
    public static void main(String[] args) {
//        Flux.range(1,10)
//                //.map(x-> Faker.instance().country().name())
//                .subscribe(new DefaultSubscriber("Lang001"));

        Flux<Integer> f = Flux.range(1,10);
        f.subscribe(new DefaultSubscriber("Lang007"));
        f.subscribe(Singleton.subscriber("Lang001"));
    }
}
