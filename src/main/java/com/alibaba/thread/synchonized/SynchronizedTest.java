package com.alibaba.thread.synchonized;

/*
 * 1.多个线程访问同一个类的同一个实例对象中的synchronized同步代码块时，存在阻塞等待获取对象锁的问题。 
 * 2.多个线程访问同一个类的不同一个实例对象中的synchronized同步代码块时，不会存在阻塞等待获取对象锁的问题。
 * 3.持有一个对象级别锁不会阻塞其他线程访问同一示例对象中的非synchronized代码。
 * 4.一个线程访问object的一个synchronized(this)同步代码块时，会阻塞其他线程对object中所有synchronized(this)同步代码块的访问。 
 * 
 * 有个比喻很好。 
 * 5.static synchronized 与 synchronized。 static synchronized地方范围是某个类，防止多个线程同时访问这个类的synchronized代码块 
 * 6.比喻 一个object就像一个大别墅，别墅里面有很多房间（也就是方法）。
 * 这些房间有上锁的（synchronized方法）和不上锁之分（普通方法）。 
 * 别墅大门口放着一把钥匙（key），这把钥匙可以打开所有上锁的房间。 
 * 想进入这栋别墅的房子的人就是想调用该对象方法的线程
 * 同步代码块就是房间里带锁的隔间，不过还是用仅有的钥匙打开
 * 设定访客每次使用完一次上锁的房间后会马上把钥匙还回去，即使他要连续使用两间上锁的房间，中间他也要把钥匙还回去，再取回来。
 */
public class SynchronizedTest {

    public static void main(String[] args) {
        // test1();
        // test2();
        // test3();
        // test4();
        // test5();
        test6();

        /*
         * 普通方法 方法块 static 方法 synchronized 方法的缺陷：若将一个大的方法声明为synchronized 将会大大影响效率，
         * 例如 若将线程类的方法 run() 声明为synchronized，由于在线程的整个生命期内它一直在运行， 
         * 因此将导致它对本类任何 synchronized 方法的调用都永远不会成功，所以就有了synchronized块。
         */
    }

    /**
     * 1.两个线程访问同一个对象的同一实例
     */
    private static void test1() {
        SyncPO p1 = new SyncPO();
        Thread ta = new Thread(p1, "A");
        Thread tb = new Thread(p1, "B");
        ta.start();
        tb.start();
    }

    /**
     * 2.两个线程访问同一个对象的不同实例
     */
    private static void test2() {
        SyncPO p1 = new SyncPO();
        SyncPO p2 = new SyncPO();
        Thread tc = new Thread(p1, "C");
        Thread td = new Thread(p2, "D");
        tc.start();
        td.start();
    }

    /**
     * 3.两个线程分别访问同步和非同步代码块
     */
    private static void test3() {
        final SyncPO syncPO = new SyncPO();
        // 调用同步代码块
        Thread t1 = new Thread(new Runnable() {

            public void run() {
                syncPO.syncMethod1();
            }
        }, "t1");
        // 调用非同步代码块
        Thread t2 = new Thread(new Runnable() {

            public void run() {
                syncPO.simpleMethod();
            }
        }, "t2");

        t1.start();
        t2.start();
    }

    /**
     * 4.两个线程分别访问同一个对象的两个同步代码块
     */
    private static void test4() {
        final SyncPO syncPO = new SyncPO();
        // 调用同步代码块
        Thread t1 = new Thread(new Runnable() {

            public void run() {
                syncPO.syncMethod1();
            }
        }, "t1");
        // 调用非同步代码块
        Thread t2 = new Thread(new Runnable() {

            public void run() {
                syncPO.syncMethod2();
                // syncPO.syncMethod3();//同步方法
            }
        }, "t2");

        t1.start();
        t2.start();
    }

    /**
     * 5.两个线程分别访问同一个对象的静态同步代码块和非同步代码块
     */
    private static void test5() {
        final SyncPO syncPO = new SyncPO();
        // 调用同步代码块
        Thread t1 = new Thread(new Runnable() {

            public void run() {
                syncPO.staticSyncMethod1(); // 锁的是class
            }
        }, "t1");
        // 调用非同步代码块
        Thread t2 = new Thread(new Runnable() {

            public void run() {
                syncPO.syncMethod3(); // 锁的是对象
            }
        }, "t2");

        t1.start();
        t2.start();
    }

    /**
     * 测试父子类
     */
    private static void test6() {
        final SonSyncPO syncPO = new SonSyncPO();
        // 调用同步代码块
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                syncPO.syncMethod3(); 
            }
        }, "t1");
        t1.start();
    }
}
