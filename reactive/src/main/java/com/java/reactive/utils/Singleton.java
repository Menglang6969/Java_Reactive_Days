package com.java.reactive.utils;

import com.github.javafaker.Faker;

public class Singleton {
    public static Faker faker(){
        return new Faker();
    }

    public static DefaultSubscriber subscriber(String name){
        return new DefaultSubscriber(name);
    }
}
