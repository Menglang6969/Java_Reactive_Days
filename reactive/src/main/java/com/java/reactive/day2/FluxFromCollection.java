package com.java.reactive.day2;

import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Stream;

public class FluxFromCollection {
    public static void main(String[] args) {

        //*** from iterators
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        Flux<Integer> flux = Flux.fromIterable(list);
        flux.filter(x -> x > 4).subscribe(x -> System.out.println("From Iterator: " + x));


        //** flux from array
        Integer[] numbers = {1, 2, 3, 4, 5};
        Flux.fromArray(numbers).subscribe(x -> System.out.println("From Array: " + x));

        //** flux from stream
        Flux<Integer> flux1 = Flux.fromStream(list::stream);
        flux1.subscribe(x -> System.out.println("From Stream Sub1: " + x));
        //if don't user list::stream stream subscribe only 1
        flux1.filter(x->x%3==0).subscribe(x -> System.out.println("From Stream Sub2: " + x));


        ///** from range
        Flux<Integer> flux2 = Flux.range(1, 10);
        flux2.subscribe(x -> System.out.println("From Flux range: " + x));


    }
}
