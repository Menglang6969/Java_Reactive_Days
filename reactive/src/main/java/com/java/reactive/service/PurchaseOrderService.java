package com.java.reactive.service;

import com.java.reactive.utils.PurchaseOrder;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class PurchaseOrderService {

    private Flux<PurchaseOrder> purchaseOrderFlux;

    public Flux<PurchaseOrder> getPurchaseOrders() {
        if(purchaseOrderFlux == null) {
            purchaseOrderFlux = getOrder();
        }
        return purchaseOrderFlux;
    }

    private Flux<PurchaseOrder> getOrder(){
        return Flux.interval(Duration.ofMillis(100))
                .map(x->new PurchaseOrder())
                .share();
    }


}
