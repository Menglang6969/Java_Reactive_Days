package com.java.reactive.day5_Operator;

import com.java.reactive.utils.OrderService;
import com.java.reactive.utils.Singleton;
import com.java.reactive.utils.UserService;
import reactor.core.publisher.Flux;

public class FlatMap {
    public static void main(String[] args) {
        UserService userService = new UserService();
        OrderService orderService = new OrderService();

        userService.getUsers()
                //.map(user->orderService.getOrder(user.getId()))
                .flatMap((user->orderService.getOrder(user.getId())))
                .subscribe(Singleton.subscriber(""));


    }
}
