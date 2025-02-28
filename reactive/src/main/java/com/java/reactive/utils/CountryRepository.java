package com.java.reactive.utils;

import com.github.javafaker.Faker;
import reactor.core.publisher.Mono;

public class CountryRepository {

    public static Mono<String> findBtId(int countryId) {
        if (countryId == 1) return Mono.just(Faker.instance().country().name().toUpperCase());
        else if (countryId == 2) return Mono.empty();
        else return Mono.error(new RuntimeException("Country not found"));
    }
}
