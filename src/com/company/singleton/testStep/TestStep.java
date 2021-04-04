package com.company.singleton.testStep;

import org.junit.Test;

/**
 * 实现f(n)：求n步台阶，一共有多少种走法？
 * @author : 胡佳伟
 * @version : 1.0.0
 * @date : 2021/3/6
 */
public class TestStep {

    @Test
    public void Test() throws IllegalAccessException {
        long start = System.currentTimeMillis();
        System.out.println(start);
        System.out.println(f(5));
        long end = System.currentTimeMillis();
        System.out.println(end);
    }

    public int f(int n) throws IllegalAccessException {
        if (n < 1) {
            throw new IllegalAccessException(n + "不能小于1");
        } else if (n == 1 || n == 2) {
            return n;
        } else {
            return f(n - 2 ) + f(n - 1);
        }
    }
}
