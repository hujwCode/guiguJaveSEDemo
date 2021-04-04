package com.company.singleton;

/**
 * 饿汉
 * @author : 胡佳伟
 * @version : 1.0.0
 * @date : 2021/3/13
 */
public class Singleton11 {
    public static final Singleton11 INSTANCE = new Singleton11();
    private Singleton11() {

    }
}
