package com.alibaba.thread.synchonized;

public class SyncPO implements Runnable {
    
    private static boolean isTrue;//不光是类实例，每一个类也对应一把锁，所以我们也可将类的静态成员函数声明为 synchronized
    
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " synchronized loop " + i);
            }
        }
    }

    public void simpleMethod() {
        System.out.println("非同步方法");
        int i = 5;
        while (i-- > 0) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
            }
        }
    }

    public void syncMethod1() {
        synchronized (this) {   //这里的this指的是调用这个方法的对象
            System.out.println("同步代码块1");
            int i = 5;
            while (i-- > 0) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {
                }
            }
        }
    }

    public void syncMethod2() {
        synchronized (this) {
            System.out.println("同步代码块2");
            int i = 5;
            while (i-- > 0) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {
                }
            }
        }
    }

    public synchronized void syncMethod3() {
        System.out.println("同步方法3");
        int i = 5;
        while (i-- > 0) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
            }
        }
    }

    public static synchronized void staticSyncMethod1() {
        System.out.println("静态同步方法1");
        int i = 5;
        while (i-- > 0) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
            }
        }
    }

}
