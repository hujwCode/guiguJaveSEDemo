package com.company.tread;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author : 胡佳伟
 * @version : 1.0.0
 * @date : 2021/4/5
 */
public class SynchronousQueueDemo {
    public static void main(String[] args) {
        SynchronousQueue synchronousQueue = new SynchronousQueue<Runnable>();
        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+"\t put 1");
                synchronousQueue.put(1);
                System.out.println(Thread.currentThread().getName()+"\t put 2");
                synchronousQueue.put(2);
                System.out.println(Thread.currentThread().getName()+"\t put 3");
                synchronousQueue.put(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },String.valueOf("a")).start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()+ "\t " +synchronousQueue.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()+ "\t " +synchronousQueue.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()+ "\t " +synchronousQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },String.valueOf("a")).start();
    }

}
