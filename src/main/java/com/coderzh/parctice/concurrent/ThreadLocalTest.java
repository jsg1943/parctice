package com.coderzh.parctice.concurrent;

import java.util.Random;

/**
 * Created by zhangwenbin on 2018/7/12.
 */
public class ThreadLocalTest {

    static class ThreadLocalRunnable implements Runnable{

        public static ThreadLocal<String> threadLocal1 = new ThreadLocal<>();

        @Override
        public void run() {
            threadLocal1.set(new Random().nextInt() + "");
            threadLocal1.set(new Random().nextInt() + "");
            System.out.println(Thread.currentThread().getName() + "'s threadLocal1 value = " + threadLocal1.get());
        }
    }

    public static void main(String[] args) {
        ThreadLocalRunnable threadLocalRunnable = new ThreadLocalTest.ThreadLocalRunnable();
        Thread thread1 = new Thread(threadLocalRunnable, "thread-1");
        Thread thread2 = new Thread(threadLocalRunnable, "thread-2");
        thread1.start();
        thread2.start();
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int p = 8;
        int i = 1;

        System.out.println(1%8);
        System.out.println(1/8);
        System.out.println((p+i/8));
        System.out.println((0x01 << (i%8)));
        System.out.println((p+i/8)|(0x01 << (i%8)));

    }

}
