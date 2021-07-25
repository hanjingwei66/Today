package com.example.today.lambda.CompletableFutureDemo;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.StopWatch;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.*;
import java.util.stream.LongStream;

public class ThreadTest {
    public static void main(String[] args) {
        System.out.println("cpu:"+Runtime.getRuntime().availableProcessors());
        ThreadPoolExecutor.DiscardPolicy discardPolicy = new ThreadPoolExecutor.DiscardPolicy();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 60, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), discardPolicy);
//        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//
//        executor.setCorePoolSize(10);
//        executor.setMaxPoolSize(20);
//        executor.setQueueCapacity(200);
//        executor.setKeepAliveSeconds(60);
//        executor.setThreadNamePrefix("hanjingweiExecutor-");
//        executor.setWaitForTasksToCompleteOnShutdown(true);
//        executor.setAwaitTerminationSeconds(60);
        Logger logger = LoggerFactory.getLogger(ThreadTest.class);
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        long countPage = 9L;
        List terminalOrderInfos = new CopyOnWriteArrayList<>();
        TerminalOrderInfo terminalOrderInfo = new TerminalOrderInfo();
        SmallTool.printTimeAndThread("准备中。。。");
        CompletableFuture[] completableFutures = LongStream.rangeClosed(1L, countPage)
                .mapToObj(j -> CompletableFuture.supplyAsync(() -> {
//                    UserCenterResult<TerminalOrderInfo> tempResult =
//                            getTerminalOrderInfo(typeValues, searchType, j, 10L);
                    List<Long> list = Arrays.asList(j);
//                    SmallTool.sleepMillis(5000);
                    SmallTool.printTimeAndThread("请求中。。。" + j);
                    return list;
                }).whenComplete((result, throwable) -> {
                            SmallTool.printTimeAndThread("合并中。。。" + j);
                            terminalOrderInfos.addAll(result);
                        })).toArray(CompletableFuture[]::new);

        CompletableFuture.allOf(completableFutures).join();
        terminalOrderInfos.forEach(System.out::println);
        Optional.ofNullable(new Shop().calculatePrice("re")).ifPresent((result)-> System.out.println("sj"));
        System.out.println(Optional.ofNullable(new Shop().calculatePrice("re")).isPresent());
//        stopWatch.stop();
//        logger.info("++++++++ getDataListByBatch() -> stopWatch: {}ms ++++++++", stopWatch.getTotalTimeMillis());
    }
}
