package com.java.reactive.utils;


import lombok.Data;

@Data
public class User {
    private int id;
    private String name;

    public User(int id) {
        this.id = id;
        this.name=Singleton.faker().name().firstName();
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
