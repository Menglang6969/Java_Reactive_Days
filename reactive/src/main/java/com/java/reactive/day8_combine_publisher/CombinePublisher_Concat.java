package com.java.reactive.day8_combine_publisher;

import com.java.reactive.utils.Singleton;
import com.java.reactive.utils.StringGenerator;
import reactor.core.publisher.Flux;

public class CombinePublisher_Concat {
    public static void main(String[] args) {

        StringGenerator generator = new StringGenerator();
        Flux<String> flux1=Flux.just("a","b");
        Flux<String> flux2=Flux.just("c","d","e");
        Flux<String> flux3=Flux.error(new RuntimeException("something went wrong"));
        flux1.concatWith(flux2).subscribe(Singleton.subscriber(""));
//        Flux.concat(flux1, flux3,flux2)
//                .subscribe(Singleton.subscriber("concat"));

        Flux.concatDelayError(flux1, flux3,flux2)
                .subscribe(Singleton.subscriber("concat"));    }


}
