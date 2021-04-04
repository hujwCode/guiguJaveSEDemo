package com.company.tread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : 胡佳伟
 * @version : 1.0.0
 * @date : 2021/3/13
 */

class MyData {
    volatile int number = 0;
    public void add() {
        this.number = 60;
    }

    public void addPlus() {
        this.number++;
    }
    AtomicInteger atomicInteger = new AtomicInteger();
    public void addAtomic() {
        atomicInteger.getAndIncrement();
    }
}



public class VolatileDemo {
    public static void main(String[] args) throws InterruptedException {
//        seeOkByVolatile();
        MyData myData = new MyData();
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    myData.addPlus();
                    myData.addAtomic();
                }
            },String.valueOf(i)).start();
        }
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+"finalnum1:"+myData.number);
        System.out.println(Thread.currentThread().getName()+"finalnum2:"+myData.atomicInteger);
    }

    /**
     * 1、验证volatile可见性
     *  1、1 假如 int number = 0;number发生改变，其他线程不知道，没可见性
     *  1、2 添加volatile，可以解决可见性问题
     * 2、验证volatile原子性
     *  2、1 完整性，某个线程在做某个具体的业务的时候，中间不可以被加塞或切割，需要保证整体的完整性，
     *       要么同时成功，要么同时失败。
     *  2、2 不保证原子性案例
     *  2、3 why
     *  2、4 如何解决原子性
     *       1、加synchronized
     *       2、使用我们的juc的AtomicInteger
     */
    private static void seeOkByVolatile() {
        MyData myData = new MyData();
        new Thread(()-> {
            System.out.println(Thread.currentThread().getName()+ "come in");
            try {
                TimeUnit.SECONDS.sleep(3);
                myData.add();
                System.out.println("update"+myData.number);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"").start();

        while (myData.number == 0) {
        }
        System.out.println(Thread.currentThread().getName() + "12");
    }

}
