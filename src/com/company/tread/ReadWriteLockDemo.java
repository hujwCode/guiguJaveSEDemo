package com.company.tread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 多个线程读一个资源类没有任何问题，为了满足并发量，读取共享的资源类是可以同时进行的。
 * 但是一个线程想去写共享的资源类是不可以的
 *
 * 总结： 读-读 共存
 *       读-写 不能共存
 *       写-写 不能共存
 * @author : 胡佳伟
 * @version : 1.0.0
 * @date : 2021/3/30
 */
class MyCache {
    private volatile Map<String,Object> map = new HashMap<>();
    private ReentrantReadWriteLock rw = new ReentrantReadWriteLock();
    public void put(String key, Object value) throws InterruptedException {
        rw.writeLock().lock();
        System.out.println(Thread.currentThread().getName()+"正在写入"+key);
        TimeUnit.MILLISECONDS.sleep(300);
        map.put(key,value);
        System.out.println(Thread.currentThread().getName()+"写入完成");
        rw.writeLock().unlock();
    }
    public void get(String key) throws InterruptedException {
        rw.readLock().lock();
        System.out.println(Thread.currentThread().getName()+"正在读取");
        TimeUnit.MILLISECONDS.sleep(300);
        Object obj = map.get(key);
        System.out.println(Thread.currentThread().getName()+"读取完成"+obj);
        rw.readLock().unlock();
    }
}


public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache myCatch = new MyCache();
        for (int i = 0; i < 5; i++) {

            int finalI = i;
            new Thread(()->{
                try {
                    myCatch.put(finalI +"", finalI +"");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            },String.valueOf(i)).start();
        }
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(()->{
                try {
                    myCatch.get(finalI +"");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }

}

