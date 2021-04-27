package com.company.tread;

import java.util.concurrent.*;

/**
 * @author : 胡佳伟
 * @version : 1.0.0
 * @date : 2021/4/25
 */
public class MyThreadPoolExecutor {
    public static void main(String[] args) {
        TimeUnit unit = null;
        BlockingQueue workQueue;
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        System.out.println(Runtime.getRuntime().availableProcessors());

        for (int i = 1; i <= 10; i++) {
            executor.execute(()->{
                System.out.println(Thread.currentThread().getName()+"\t 执行业务");
            });
        }
        executor.shutdown();
    }
}
