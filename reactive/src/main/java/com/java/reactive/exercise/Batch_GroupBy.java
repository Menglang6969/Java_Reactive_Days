package com.java.reactive.exercise;

import com.java.reactive.service.OrderService;
import com.java.reactive.service.ProcessOrder;
import com.java.reactive.utils.PurchaseOrder;
import com.java.reactive.utils.Singleton;
import com.java.reactive.utils.StringGenerator;
import com.java.reactive.utils.Utils;
import reactor.core.publisher.Flux;

import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class Batch_GroupBy {
    public static void main(String[] args) {
        OrderService orderService=new OrderService();

        ProcessOrder processOrder=new ProcessOrder();

        Map<String, Function<Flux<PurchaseOrder>,Flux<PurchaseOrder>>> map=Map.of(
                "Kids",processOrder.KidsProcess(),
                "Sports",processOrder.SportProcess()
        );
        Set<String> set=map.keySet();
        orderService.orderFlux()
                .filter(p->set.contains(p.getCategory()))
                .groupBy(PurchaseOrder::getCategory)
                .flatMap(gf->map.get(gf.key()).apply(gf))
                .subscribe(Singleton.subscriber(""));

        Utils.delay(30);

    }


}
