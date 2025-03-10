package com.java.reactive.service;

import com.java.reactive.utils.PurchaseOrder;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class InventoryService {

    public InventoryService() {
        db.put("Kids",100);
        db.put("Clothing",100);
    }

    private Map<String, Integer> db=new HashMap<>();

    public Consumer<PurchaseOrder> consumeOrderStreaming(){
        return p->db.computeIfPresent(p.getCategory(),(k,v)->v-p.getQuantity());
    }

    public Flux<String> getInventory() {
        return Flux.interval(Duration.ofSeconds(2)).map(x -> db.toString());
    }
}
