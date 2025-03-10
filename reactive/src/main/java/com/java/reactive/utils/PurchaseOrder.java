package com.java.reactive.utils;

import lombok.Data;

@Data
public class PurchaseOrder {
    private String productName;
    private double price;
    private int quantity;
    private String category;

    public PurchaseOrder(){
        this.price= Double.parseDouble(Singleton.faker().commerce().price());
        this.productName = Singleton.faker().commerce().productName();
        this.quantity=Singleton.faker().random().nextInt(1,10);
        this.category=Singleton.faker().commerce().department();

    }
}
