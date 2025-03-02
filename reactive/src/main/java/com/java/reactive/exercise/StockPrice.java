package com.java.reactive.exercise;

import com.java.reactive.utils.Utils;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.CountDownLatch;

public class StockPrice {
    public static void main(String[] args) throws InterruptedException {
        StockPriceUpDown priceGenerate = new StockPriceUpDown();
        CountDownLatch countDownLatch = new CountDownLatch(1);

        priceGenerate.getPrice()
                .subscribe(new Subscriber<Integer>() {
                    private Subscription subscription;
                    @Override
                    public void onSubscribe(Subscription subscription) {
                        this.subscription = subscription;
                        subscription.request(Long.MAX_VALUE);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("Values: " + integer);
                      //  countDownLatch.countDown();
                        if(integer>105 || integer<90){
                            subscription.cancel();
                            System.out.println("Canceled");
                        }
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("Error: " + throwable.getMessage());
                        countDownLatch.countDown();
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Complete");
                        countDownLatch.countDown();
                    }
                });
        countDownLatch.await();

    }

}
