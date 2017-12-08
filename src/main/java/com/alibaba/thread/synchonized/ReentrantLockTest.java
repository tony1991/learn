package com.alibaba.thread.synchonized;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 类ReentrantLockTest.java的实现描述：TODO 类实现描述 
 * @author tony 2015年7月30日 下午3:12:37
 * 
 * 同一个线程id被连续输出两次，正确
 */
public class ReentrantLockTest implements Runnable{
    ReentrantLock lock = new ReentrantLock();

    public void get() {
        lock.lock();
        System.out.println(Thread.currentThread().getId());
        set();
        lock.unlock();
    }

    public void set() {
        lock.lock();
        System.out.println(Thread.currentThread().getId());
        lock.unlock();
    }

    @Override
    public void run() {
        get();
    }

    public static void main(String[] args) {
        ReentrantLockTest lockTest = new ReentrantLockTest();
        new Thread(lockTest).start();
        new Thread(lockTest).start();
        new Thread(lockTest).start();
    }
}
