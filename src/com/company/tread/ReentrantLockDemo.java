package com.company.tread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁
 *
 * 总结：线程可以进入任何一个他已经拥有的锁锁同步的代码块
 * @author : 胡佳伟
 * @version : 1.0.0
 * @date : 2021/3/28
 */
public class ReentrantLockDemo {
    public static void main(String[] args) throws Exception{
        Phone phone = new Phone();
        new Thread(()->{
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }

        },"t1").start();
        new Thread(()->{
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }

        },"t2").start();

       Runnable target;
       Thread thread3 = new Thread(phone);
       Thread thread4 = new Thread(phone);
       thread3.start();
       thread4.start();
    }
}


class Phone implements Runnable {
    public synchronized void sendSMS() throws Exception {
        System.out.println(Thread.currentThread().getId() + "invoked sendSMS");
        sendEmail();
    }
    public synchronized void sendEmail() throws Exception {
        System.out.println(Thread.currentThread().getId() + "invoked sendEmail");

    }
    Lock lock = new ReentrantLock();
    @Override
    public void run() {
        get();
    }

    public void get(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName() + "get()");
            set();
        }catch (Exception e){
            throw e;
        }finally {
            lock.unlock();
        }
    }

    public void set(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName() + "set()");
        }catch (Exception e){
            throw e;
        }finally {
            lock.unlock();
        }
    }
}