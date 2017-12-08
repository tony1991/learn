package com.alibaba.thread.volitile;

/**
 * 类VolitileTest.java的实现描述：TODO 类实现描述
 * 
 * @author tony 2015年7月27日 下午8:51:36 Volatile修饰的成员变量在每次被线程访问时，都强迫从共享内存中重读该成员变量的值。
 * 而且，当成员变量发生变化时，强迫线程将变化值回写到共享内存。这样在任何时刻，两个不同的线程总是看到某个成员变量的同一个值。 效率低
 */
public class VolitileTest {

    public static volatile int count = 0;
    public static int count2 = 0;

    public static void main(String args[]) {
        commonMethod();
        volitileMethod();
    }
    
    private static void commonMethod() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            new Thread(new Runnable() {

                public void run() {
                    count2++;
                }
            }).start();
        }
        long endTime = System.currentTimeMillis();
        long costTime = endTime - startTime;
        System.out.println("耗时：" + costTime);
    }

    private static void volitileMethod() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            new Thread(new Runnable() {

                public void run() {
                    count++;
                }
            }).start();
        }
        long endTime = System.currentTimeMillis();
        long costTime = endTime - startTime;
        System.out.println("耗时：" + costTime);
    }
}
