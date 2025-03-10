package com.java.reactive.utils;

import reactor.core.publisher.Flux;

public class UserService {
    public Flux<User> getUsers() {
        return Flux.range(1,2).map(User::new);
    }
}
