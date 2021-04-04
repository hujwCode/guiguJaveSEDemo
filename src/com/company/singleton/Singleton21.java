package com.company.singleton;

import java.util.Properties;

/**
 * @author : 胡佳伟
 * @version : 1.0.0
 * @date : 2021/3/13
 */
public class Singleton21 {
    public static Singleton21 INSTANCE = null;
    static {
        Properties properties = new Properties();
        INSTANCE = new Singleton21();
    }

    private Singleton21() {
    }
}
