package com.company.singleton;

/**
 * @author : 胡佳伟
 * @version : 1.0.0
 * @date : 2021/3/14
 */
public class SingletonDemo {
    private volatile static SingletonDemo INSTANCE = null;

    private SingletonDemo() {
        System.out.println(Thread.currentThread().getName() + "  构造方法");
    }
    // DCL(Double Check Lock)双端检索机制
    public static SingletonDemo getINSTANCE() {
        if (INSTANCE == null) {
            synchronized (SingletonDemo.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SingletonDemo();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
//        System.out.println(SingletonDemo.getINSTANCE() == SingletonDemo.getINSTANCE());
//        System.out.println(SingletonDemo.getINSTANCE() == SingletonDemo.getINSTANCE());
//        System.out.println(SingletonDemo.getINSTANCE() == SingletonDemo.getINSTANCE());

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                SingletonDemo.getINSTANCE();
            }, String.valueOf(i)).start();
        }

    }
}
