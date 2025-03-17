package com.java.reactive.utils;


import lombok.Data;

@Data
public class SlackMessage {
    private final String FORMAT="[%s -> %s] : %s";
    private String sender;
    private String message;
    private String receiver;

    @Override
    public String toString() {
        return String.format(FORMAT,sender,receiver,message);
    }
}
