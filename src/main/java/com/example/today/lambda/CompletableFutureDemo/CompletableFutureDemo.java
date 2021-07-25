package com.example.today.lambda.CompletableFutureDemo;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CompletableFutureDemo {
    public static void main(String[] args) {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        CompletableFuture future = new CompletableFuture();
        System.out.println(Thread.currentThread().getName()+"it main");
        CompletableFuture<List> resultcount = CompletableFuture.supplyAsync(() -> {
            //1.获取总数量计算总页数
            sleep1();
            System.out.println(Thread.currentThread().getName());
            SmallTool.printTimeAndThread("resultcount");
            Integer count = 100;
            return count;
        }).thenCompose(
                //2.根据总页数循环创建线程请求数据
                count -> CompletableFuture.supplyAsync(
                () -> {
                    CompletableFuture[] completableFutures = IntStream.rangeClosed(1, count)
                            .mapToObj(i -> Arrays.asList(i))
                            .map(i -> CompletableFuture.supplyAsync(() -> {
                                SmallTool.sleepMillis(3000);
                                SmallTool.printTimeAndThread("currentPage:" + i);
                                return "当前page" + i;
                            },executor)).toArray(CompletableFuture[]::new);
                    //合并数据
                    CompletableFuture.allOf(completableFutures).join();
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(1);
                    return arrayList;
                }
        )).thenCombine(CompletableFuture.supplyAsync(() -> {
            Integer currentPage = 4;
            SmallTool.printTimeAndThread("currentPage" + currentPage);
            return currentPage;
        }), (pieceList, currentPage) -> {
            List alllist = new ArrayList();
            alllist.add(2);
            alllist.addAll(pieceList);
            alllist.forEach(System.out::println);
            return alllist;
        });

        System.out.println("result:"+resultcount.join());
    }
    public static void sleep1(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
