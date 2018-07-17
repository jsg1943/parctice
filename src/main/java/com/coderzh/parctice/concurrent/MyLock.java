package com.coderzh.parctice.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhangwenbin on 2018/5/29.
 */
public class MyLock {

    private String name;

    private final Lock lock = new ReentrantLock();

    public void updateName(String myName, MyLock backup_) {
        lock.lock();
        try {
            this.name = myName;
            System.out.println("updateName method this.name=" + name);
            backup_.confireName(myName);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    private synchronized void confireName(String myName) {
        lock.lock();
        try {
            System.out.println("confireName method this.name=" + name + " ,myName=" + myName);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}
