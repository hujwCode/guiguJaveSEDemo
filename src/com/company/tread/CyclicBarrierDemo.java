package com.company.tread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author : 胡佳伟
 * @version : 1.0.0
 * @date : 2021/4/4
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4,()->{
            System.out.println("召唤神龙");
        });
        for (int i = 1; i <= 4; i++) {
            int finalI = i;
            new Thread(()->{
                System.out.println("收集龙珠"+ finalI);
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }

    }
}
