package com.java.reactive.utils;

import java.util.function.Consumer;

public class Utils {
    public static Consumer<String> onNext() {
        return x -> System.out.println("On Next: " + x);
    }

    public static Consumer<Throwable> onError() {
        return x -> System.out.println("On Error: " + x.getMessage());
    }

    public static Runnable onComplete() {
        return () -> System.out.println("On Completed.");
    }

    public static void delay(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }


}
