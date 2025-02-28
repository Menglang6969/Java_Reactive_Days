package com.java.reactive.day2;

import com.java.reactive.utils.Utils;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class FluxInterval {
    public static void main(String[] args) {
        Flux.interval(Duration.ofSeconds(2))
        .subscribe(x->System.out.println("Times: "+x));
Duration duration = Duration.ofDays(2);
        Utils.delay(5);
    }
}
