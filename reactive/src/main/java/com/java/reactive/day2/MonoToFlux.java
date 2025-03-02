package com.java.reactive.day2;

import com.github.javafaker.Faker;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoToFlux {
    public static void main(String[] args) {
        //**** mono to flux *************
//        Mono<Integer> mono = Mono.just(1);
//        Flux<Integer> flux2=Flux.from(mono);
//        getFluxName(flux2);

        //***** flux to mono **********
        Flux<Integer> flux3=Flux.just(1,2,3,4);
        //meet the first condition return
       // flux3.next().filter(x->x>1).subscribe(x->System.out.println(Faker.instance().book().title()+": num "+x));
        flux3.filter(x->x>2).next().subscribe( x-> System.out.println( Faker.instance().book().title()+": "+ x ));


    }

    public static void getFluxName(Flux<Integer> flux) {
        flux.subscribe(x->System.out.println(Faker.instance().name().fullName()+": "+x));
    }
}
