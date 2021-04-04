package com.company.singleton;

/**
 * @author : 胡佳伟
 * @version : 1.0.0
 * @date : 2021/2/25
 */
public class TestSingleton2 {
    public static void main(String[] args) {
        Singleton2 s = Singleton2.INSTANCE;
        System.out.println(s);
    }
}
