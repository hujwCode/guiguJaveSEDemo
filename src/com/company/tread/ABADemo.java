package com.company.tread;

import sun.jvm.hotspot.types.CIntegerField;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 解决ABA问题 引用AtomicsTampedReference
 *
 * @author : 胡佳伟
 * @version : 1.0.0
 * @date : 2021/3/23
 */

public class ABADemo {
    static AtomicReference<Integer> atomicReference = new AtomicReference(100);
    static AtomicStampedReference<Integer> stampedReference = new AtomicStampedReference<>( 100,1);

    public static void main(String[] args) throws InterruptedException {
//        System.out.println("=========以下是ABA问题的产生=========");
//        new Thread(() -> {
//            atomicReference.compareAndSet(100, 101);
//            atomicReference.compareAndSet(101, 100);
//        },"t1").start();
//        new Thread(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            System.out.println(atomicReference.compareAndSet(100, 2019)+"\t"+atomicReference.get());
//        },"t2").start();
//
//        TimeUnit.SECONDS.sleep(2);
        System.out.println("=========以下是ABA问题的解决=========");
        new Thread(() -> {
            int stamp = stampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"第一次版本号"+ stamp);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stampedReference.compareAndSet(100,101, stamp, stamp++);
            System.out.println(Thread.currentThread().getName() + "第二次版本号" + stamp);
            stampedReference.compareAndSet(101,100, stamp, stamp++);
            System.out.println(Thread.currentThread().getName() + "第三次版本号" + stamp);
        },"t3").start();


        new Thread(() -> {
            int stamp = stampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + "第一次版本号"+ stamp);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(stampedReference.compareAndSet(100, 2019,stamp, stamp++)+"\t"+atomicReference.get());
        },"t4").start();
    }
}
