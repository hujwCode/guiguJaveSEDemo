package com.company.tread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : 胡佳伟
 * @version : 1.0.0
 * @date : 2021/3/20
 */
public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);

        System.out.println(atomicInteger.compareAndSet(5,2020) + "\t current data:" + atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5,2021) + "\t current data:" + atomicInteger.get());
        System.out.println(atomicInteger.getAndIncrement());
        System.out.println(atomicInteger.addAndGet(333 ));
    }
}
