package com.company.tread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author : 胡佳伟
 * @version : 1.0.0
 * @date : 2021/4/4
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        // 模拟三个停车位
        Semaphore semaphore = new Semaphore( 3, true);
        // 模拟有6辆车
        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
                try{
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"\t抢到车位");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName()+"\t停车三秒后离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }


    }
}
