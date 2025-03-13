package com.java.reactive.day8_combine_publisher;

import com.java.reactive.utils.Singleton;
import com.java.reactive.utils.Utils;
import reactor.core.publisher.Flux;

public class CombinePublisher_Zip {
    public static void main(String[] args) {

        Flux.zip(getBody(), getEngin(), getTires()).subscribe(Singleton.subscriber("Car: "));//base less publisher

        Utils.delay(30);
    }

    public static Flux<String> getBody() {
        return Flux.just("Yan", "Door", "Gare");
    }

    public static Flux<String> getEngin() {
        return Flux.just("EnginA", "EnginB", "EnginC");
    }

    public static Flux<String> getTires() {
        return Flux.just("Tires1", "Tires2");
    }

}
