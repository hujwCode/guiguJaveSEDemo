package com.company.tread;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 集合类不安全问题
 *
 * @author : 胡佳伟
 * @version : 1.0.0
 * @date : 2021/3/24
 */
public class ContainerNotSafeDemo {
    public static void main(String[] args) {
//        listNoSafe();
        Set<String> set = new CopyOnWriteArraySet();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(set);
            },String.valueOf(i)).start();
        }
        new HashSet<>();

    }

    public static void listNoSafe() {
        List<String> list = new CopyOnWriteArrayList<>();
//        Collections.synchronizedList(list);
//        CopyOnWriteArrayList
//                new ArrayList<>();
        for (int i = 1; i <= 30 ; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}
