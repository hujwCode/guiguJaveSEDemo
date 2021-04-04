package com.company.singleton.testStep;

import org.junit.Test;

/**
 * @author : 胡佳伟
 * @version : 1.0.0
 * @date : 2021/3/7
 */
public class TestStep2 {

    @Test
    public void test() throws IllegalAccessException {
        long start = System.currentTimeMillis();
        System.out.println(start);
        System.out.println(loop(10));
        long end = System.currentTimeMillis();
        System.out.println(end);
    }

    public int loop(int n) throws IllegalAccessException {

        if (n < 1) {
            throw new IllegalAccessException(n + "不能小于1");
        }
        if (n == 1 || n == 2) {
            return n;
        }
        int sum = 0;
        // 初始化为走到第一级台阶的走法
        int one = 2;
        // 初始化为走到第二级台阶的走法
        int two = 1;
        for (int i = 3; i <= n; i++) {
            one = loop(n-2);
            two = loop(n-1);
            sum =  one + two;
        }
        return sum;
    }
}
