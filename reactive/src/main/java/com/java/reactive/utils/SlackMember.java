package com.java.reactive.utils;

import java.util.function.Consumer;

public class SlackMember {
    private String name;
    private Consumer<String> messageConsumer;

    public SlackMember(String name) {
        this.name = name;
    }

     void received(String msg){
        System.out.println(msg);
    }

     void setMessageConsumer(Consumer<String> messageConsumer) {
        this.messageConsumer = messageConsumer;
    }

     String getName() {
        return name;
    }

    public void says(String msg){
        this.messageConsumer.accept(msg);
    }


}
