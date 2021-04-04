package com.company.singleton;

/**
 * @author : 胡佳伟
 * @version : 1.0.0
 * @date : 2021/3/7
 */
public class Exam5 {
    static int s = 0;
    int i;
    int j;
    {
        int i = 0;
        i++;
        j++;
        s++;
    }
    public void test(int j) {
        j++;
        i++;
        s++;
    }

    public static void main(String[] args) {
        Exam5 obj1 = new Exam5();
        Exam5 obj2 = new Exam5();
        obj1.test(10);
        obj1.test(20);
        obj2.test(30);
        System.out.println(obj1.i+","+obj1.j+","+ s);
        System.out.println(obj2.i+","+obj2.j+","+ s);



    }
}
