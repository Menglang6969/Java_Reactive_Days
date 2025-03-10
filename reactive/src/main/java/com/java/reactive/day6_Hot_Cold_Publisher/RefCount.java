package com.java.reactive.day6_Hot_Cold_Publisher;

import com.java.reactive.utils.Singleton;
import com.java.reactive.utils.Utils;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class RefCount {
    public static void main(String[] args) {

        Flux<String> flux = Flux.fromStream(() -> getMovies())
                .delayElements(Duration.ofSeconds(1))
                .publish()
                .refCount(2);//wait for {amt subscriber}  to emit

        flux.subscribe(Singleton.subscriber("Mr.Lang"));
        Utils.delay(5);
        flux.subscribe(Singleton.subscriber("Mr.Long"));
        Utils.delay(60);
    }

    private static Stream<String> getMovies() {
        System.out.println("Loading Movies.....");
        return Stream.of("scene 1", "scene 2", "scene 3", "scene 4", "scene 5", "scene 6");

    }
}
