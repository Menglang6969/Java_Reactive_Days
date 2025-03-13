package com.java.reactive.service;

import com.java.reactive.utils.PurchaseOrder;
import reactor.core.publisher.Flux;

import java.util.function.Function;

public class ProcessOrder {
    public Function<Flux<PurchaseOrder>, Flux<PurchaseOrder>> SportProcess() {
        return flux->{
            return flux.doOnNext(po->po.setPrice(po.getPrice()*1.1*po.getQuantity()))
                    .doOnNext(p->p.setProductName("[["+p.getProductName()+"]]"));
        };
    }


    public Function<Flux<PurchaseOrder>, Flux<PurchaseOrder>> KidsProcess() {
        return flux->{
            return flux
                    .doOnNext(po->po.setPrice(po.getPrice()*0.5*po.getQuantity()))
                    .doOnNext(p->p.setProductName("[["+p.getProductName()+"]]"))
                    .flatMap(p->Flux.just(p,getFreePurchaseOrder()))
                    ;
        };
    }

    public PurchaseOrder getFreePurchaseOrder() {
        PurchaseOrder po = new PurchaseOrder();
        po.setPrice(0d);
        po.setProductName("Free +"+po.getProductName());
        return po;
    }
}
