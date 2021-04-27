package com.company.tread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : 胡佳伟
 * @version : 1.0.0
 * @date : 2021/4/8
 */
public class ShareData {
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() throws Exception{
        lock.lock();
        try {
            // 1。判断
            while (number != 0) {
                // 等待，不能生产
                condition.await();
            }
            // 2。干活
            number++;
            System.out.println(Thread.currentThread().getName()+"\t" + number);
            // 3.通知唤醒
            condition.signalAll();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }

    }

    public void decrement() throws Exception{
        lock.lock();
        try {
            // 1。判断
            while (number == 0) {
                // 等待，不能生产
                condition.await();
            }
            // 2。干活
            number--;
            System.out.println(Thread.currentThread().getName()+"\t" + number);
            // 3.通知唤醒
            condition.signalAll();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }

    }
}
