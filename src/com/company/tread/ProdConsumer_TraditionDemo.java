package com.company.tread;

/**
 * @author : 胡佳伟
 * @version : 1.0.0
 * @date : 2021/4/8
 */
public class ProdConsumer_TraditionDemo {
    public static void main(String[] args) throws Exception {
        ShareData shareData = new ShareData();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        },"AA").start();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        },"BB").start();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        },"CC").start();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        },"DD").start();
    }
}
