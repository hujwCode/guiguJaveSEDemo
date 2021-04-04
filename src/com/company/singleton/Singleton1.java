package com.company.singleton;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

/**
 * 饿汉式单例
 * 1、构造器私有化
 * 2、含有一个静态变量保存这个唯一实例
 * 3、直接暴露 或 用静态变量get方法获取
 * @author : 胡佳伟
 * @version : 1.0.0
 * @date : 2021/2/25
 */
public class Singleton1 {
    public static final Singleton1 INSTANCE = new Singleton1();
    private Singleton1() {

    }

}
