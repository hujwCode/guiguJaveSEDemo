package com.company;

/**
 * 自增变量 求i，j，k值
 * @author : 胡佳伟
 * @version : 1.0.0
 * @date : 2021/2/25
 */
public class increase {
    public static void main(String[] args) {
        int i = 1;
        i = i++;
        int j = i++;
        int k = i + ++i * i++;
        System.out.println(i);
        System.out.println(j);
        System.out.println(k);
    }
}
