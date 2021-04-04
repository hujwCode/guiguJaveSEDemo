package com.company.singleton;

/**
 * @author : 胡佳伟
 * @version : 1.0.0
 * @date : 2021/2/25
 */
public class TestSingleton1 {
    public static void main(String[] args) {

        Singleton1 s = Singleton1.INSTANCE;
        System.out.println(s);
    }
}
