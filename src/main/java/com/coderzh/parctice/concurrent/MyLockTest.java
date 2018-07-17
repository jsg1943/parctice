package com.coderzh.parctice.concurrent;

/**
 * Created by zhangwenbin on 2018/5/29.
 */
public class MyLockTest {
    public static void main(String[] args) {
        final MyLock myLockTest1 = new MyLock();
        final MyLock myLockTest2 = new MyLock();

        new Thread(new Runnable(){
            @Override
            public void run() {
                myLockTest1.updateName("MyLockTest 1", myLockTest2);
            }
        }).start();

        new Thread(new Runnable(){
            @Override
            public void run() {
                myLockTest2.updateName("MyLockTest 2", myLockTest1);
            }
        }).start();

    }
}
