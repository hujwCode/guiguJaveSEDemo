package com.company.tread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author : 胡佳伟
 * @version : 1.0.0
 * @date : 2021/4/5
 * <p>
 * 1。 队列
 * <p>
 * 2。阻塞队列
 * 2。1 阻塞队列有没有好的一面
 * <p>
 * 2。2 不得不阻塞，你怎么处理
 */
public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);
//        System.out.println(blockingQueue.add(1));
//        System.out.println(blockingQueue.add(2));
//        System.out.println(blockingQueue.add(3));
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.element());
//
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.toString());

//        System.out.println(blockingQueue.offer(1));
//        System.out.println(blockingQueue.offer(2));
//        System.out.println(blockingQueue.offer(3));
//        System.out.println(blockingQueue.offer(3));
//
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.peek());
//
//        System.out.println(blockingQueue.toString());


//        blockingQueue.put(1);
//        blockingQueue.put(2);
//        blockingQueue.put(3);
//        System.out.println("====");
//
//        blockingQueue.take();
//        blockingQueue.take();
//        blockingQueue.put(4);
//
//        blockingQueue.take();
//        blockingQueue.take();
//
//        System.out.println(blockingQueue.toString());

        System.out.println(blockingQueue.offer(1,2L,TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer(1,2L,TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer(1,2L,TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer(1,2L,TimeUnit.SECONDS));


    }
}
