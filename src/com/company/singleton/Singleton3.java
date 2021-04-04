package com.company.singleton;

import java.util.Properties;

/**
 * @author : 胡佳伟
 * @version : 1.0.0
 * @date : 2021/2/25
 */
public class Singleton3 {
    public static Singleton3 INSTANCE = null;
    static {
        Properties pro = new Properties();
        INSTANCE = new Singleton3();
    }
    private Singleton3() {

    }
}
