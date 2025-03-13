package com.java.reactive.exercise;

import com.java.reactive.day9_Batching.RevenueReport;
import com.java.reactive.utils.BookOrder;
import com.java.reactive.utils.Singleton;
import com.java.reactive.utils.Utils;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Batching_Exercise {
    public static void main(String[] args) {

        Set categories=Set.of("Fantasy","Historical","Mystery");

        fluxOrder()
                .filter(book->categories.contains(book.getCategory()))
                .buffer(Duration.ofSeconds(2))
                .map(Batching_Exercise::calculateRevenueReport)
                .subscribe(Singleton.subscriber(""));

        Utils.delay(40);

    }

    private static RevenueReport calculateRevenueReport(List<BookOrder> books) {
       Map<String,Double> map=  books.stream()
                .collect(Collectors.groupingBy(BookOrder::getCategory,
                        Collectors.summingDouble(BookOrder::getPrice)
                        ));
     //  System.out.println("Book Map: "+map.get("Fantasy"));
        return new RevenueReport(map);
    }


    private static Flux<BookOrder> fluxOrder(){
        return Flux.interval(Duration.ofMillis(100))
                .map(x->new BookOrder());
    }
}
