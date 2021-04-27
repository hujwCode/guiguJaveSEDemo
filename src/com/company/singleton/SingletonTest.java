package com.company.singleton;

/**
 * @author : 胡佳伟
 * @version : 1.0.0
 * @date : 2021/4/18
 * 1。有私有的构造类
 * 2。暴露一个获取她的方法
 * 3。是静态的
 */
public class SingletonTest {
    private static final SingletonTest INSTANCE = new SingletonTest();

    public static SingletonTest getINSTANCE() {
        return INSTANCE;
    }
    private SingletonTest() {

    }
}
