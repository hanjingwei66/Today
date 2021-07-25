package com.example.today.lambda.CompletableFutureDemo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Shop {
    public Future<Double> getPriceAsync(String product){
        CompletableFuture<Double> future = new CompletableFuture<>();
        new Thread(() ->{
            try {
                double price = calculatePrice("huawei");
                //完成时通知futrue是否完成
                future.complete(2.0);
            }catch (Exception ex){
                future.completeExceptionally(ex);
            }

        }).start();

        return future;
    };
    public double calculatePrice(String product){
        delay();
        return  2.0;
    }
    public static void delay(){
        try {
            Thread.sleep(1000L);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

    }
}
