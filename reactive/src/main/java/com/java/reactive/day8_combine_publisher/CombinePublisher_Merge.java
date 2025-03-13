package com.java.reactive.day8_combine_publisher;

import com.java.reactive.utils.*;
import reactor.core.publisher.Flux;

public class CombinePublisher_Merge {
    public static void main(String[] args) {

        Flux.merge(
                AirAsia.getFlight(),
                BankKokAir.getFlight(),
                AngKorAirLine.getFlight()
        ).subscribe(Singleton.subscriber(""));

        Utils.delay(30);
    }

}
