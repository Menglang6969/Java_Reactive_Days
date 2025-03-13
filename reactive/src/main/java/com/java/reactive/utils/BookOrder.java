package com.java.reactive.utils;

import com.github.javafaker.Book;
import lombok.Data;

@Data
public class BookOrder {
    private String title;
    private String category;
    private double price;

    public BookOrder(){
      Book book= Singleton.faker().book();
      this.title=book.title();
      this.category= book.genre();
      this.price=Double.parseDouble(Singleton.faker().commerce().price());
    }
}
