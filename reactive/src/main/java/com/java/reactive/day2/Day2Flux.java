package com.java.reactive.day2;

import com.java.reactive.utils.Utils;
import reactor.core.publisher.Flux;

public class Day2Flux {
    public static void main(String[] args) {
       Flux<Integer> flux= Flux.just(1,2,3,4,5);
////        flux.subscribe(x->System.out.println(x));
//        flux.map(Object::toString)
//                .subscribe(Utils.onNext(),Utils.onError(),Utils.onComplete());


        //***multiple subscribe
        flux.filter(x->x%2==0).subscribe(x->System.out.println("Sub A"+x));
        flux.map(Object::toString).subscribe(Utils.onNext(),Utils.onError(),Utils.onComplete());
    }



}
