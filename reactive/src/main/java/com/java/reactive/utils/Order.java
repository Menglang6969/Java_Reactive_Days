package com.java.reactive.utils;


import lombok.Data;

@Data
public class Order {
    private int id;
    private String productName;
    private int userId;
    private double price;

    public Order(int userId){
        this.userId = userId;
        this.price= Double.parseDouble(Singleton.faker().commerce().price());
        this.productName = Singleton.faker().commerce().productName();
    }
}
