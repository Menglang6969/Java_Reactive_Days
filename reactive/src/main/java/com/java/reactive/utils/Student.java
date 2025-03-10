package com.java.reactive.utils;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Student {

    private  String name;
    private int age;

    public Student() {
        this.name = Singleton.faker().name().firstName();
        this.age = Singleton.faker().random().nextInt(10, 20);
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }


}
