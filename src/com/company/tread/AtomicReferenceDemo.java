package com.company.tread;

import com.sun.org.apache.xpath.internal.objects.XString;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author : 胡佳伟
 * @version : 1.0.0
 * @date : 2021/3/23
 */
@Data
@AllArgsConstructor
class User {
    String userName;
    Integer age;
}

public class AtomicReferenceDemo {
    public static void main(String[] args) {
        AtomicReference<User> atomicReference = new AtomicReference<>();
        User user1  = new User("zs", 12);
        User user2  = new User("lisi", 23);
        atomicReference.set(user1);
        boolean b = atomicReference.compareAndSet(user1, user2);
        System.out.println(b+"\t"+ atomicReference.get().toString());
    }
}
