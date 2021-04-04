package com.company.tread;

import java.util.concurrent.CountDownLatch;

/**
 * @author : 胡佳伟
 * @version : 1.0.0
 * @date : 2021/4/4
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t bb");
                countDownLatch.countDown();
            }, CountryEnum.forEach_Country(i).getRetMsg()).start();
        }
        countDownLatch.await();
        System.out.println("班长a");
    }
}
