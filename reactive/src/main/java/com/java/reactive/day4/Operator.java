package com.java.reactive.day4;

import com.java.reactive.utils.Singleton;
import reactor.core.publisher.Flux;

public class Operator {
    public static void main(String[] args) {
//        Flux.range(1,20)
//                .handle((number,sink)->{//handle = filter+map
//                    if(number % 2 == 0){
//                        sink.next(number);
//                    }else
//                        sink.next(number+2);
//                }).subscribe(Singleton.subscriber("Number "));



//      ********************  handle operator
     /*   Flux.generate(sink -> {
            sink.next(Singleton.faker().country().name());
        }).map(Object::toString).handle((name, sink) -> {
            if (name.equalsIgnoreCase("brazil")) sink.complete();
            else sink.next(name);
        }).subscribe(Singleton.subscriber("Country "));

      */


        Flux.range(1, 20)
                .map(x -> {
                    Integer num=Singleton.faker().random().nextInt(1,10);
                    if(num>5) {
                        throw new RuntimeException("Error.....");
                    }
                    return x;
                })
                .doOnCancel(()->System.out.println(" Do on Cancel"))
                .doOnComplete(()->System.out.println(" Do on Complete"))
                .doOnDiscard(Object.class, x->System.out.println(" Do on Discard"))
                .doOnError(e->System.out.println(" Do on Error"+e.getMessage()))
                .doOnNext(x->System.out.println(" Do on Next"+x.toString()))
                .doOnRequest(l->System.out.println(" Do on Request"+l))
                .doOnSubscribe(s->System.out.println(" Do on Subscribe"+s.toString()))
                .doOnTerminate(()->System.out.println(" Do on Terminate"))
                .doFirst(()->System.out.println(" Do on First"))
                .doFinally(x->System.out.println("Do Finally"+x.toString()))
                .subscribe(Singleton.subscriber(""));
                ;


    }
}
