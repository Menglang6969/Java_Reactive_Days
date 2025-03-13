package com.java.reactive.utils;

import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class StringGenerator {
    List<String> listName = new ArrayList<>();

    public Flux<String> getName() {
        return Flux.generate(sink -> {
            String name = Singleton.faker().name().firstName();
            System.out.println("=============> generate Name: " + name);
            listName.add(name);
            sink.next(name);
        }).cast(String.class).startWith(getFromCached());
    }

    public Flux<String> getFromCached() {
        return Flux.fromIterable(listName);
    }


}
