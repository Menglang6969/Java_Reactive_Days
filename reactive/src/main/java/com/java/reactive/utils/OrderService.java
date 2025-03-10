package com.java.reactive.utils;

import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderService {
    private static Map<Integer, List<Order>> db=new HashMap<>();

    static {
        List<Order> list=List.of(
                new Order(1),
                new Order(1),
                new Order(1)
        );

        List<Order> list2=List.of(
                new Order(2),
                new Order(2),
                new Order(2)
        );

        db.put(1, list);
        db.put(2, list2);
    }

    public Flux<Order> getOrder(int userId) {
        return Flux.create(fluxSink->{
         //  db.get(userId).forEach(order->fluxSink.next(order));
            db.get(userId).forEach(fluxSink::next);
           fluxSink.complete();
        });
    }
}
