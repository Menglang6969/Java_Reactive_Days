package com.java.reactive.service;

import com.java.reactive.utils.PurchaseOrder;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class OrderService {

    public Flux<PurchaseOrder> orderFlux(){
        return Flux.interval(Duration.ofMillis(100))
                .map(x->new PurchaseOrder());
    }
}
