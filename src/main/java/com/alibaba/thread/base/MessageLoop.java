package com.alibaba.thread.base;

/**
 * 类SleepMessages.java的实现描述：TODO 类实现描述
 * 
 * @author tony 2015年7月30日 上午10:33:25 it throws InterruptedException. 
 * This is an exception that sleep throws when
 * another thread interrupts the current thread while sleep is active. 
 * The interrupt mechanism is implemented using an internal flag known as the interrupt status.标志位 
 * 注意区分interrupted和isInterrupted方法,前者调用时会清空状态，后者不会
 */
public class MessageLoop implements Runnable {

    public void run() {
        String importantInfo[] = { "Mares eat oats", "Does eat oats", "Little lambs eat ivy", "A kid will eat ivy too" };
        try {
            for (int i = 0; i < importantInfo.length; i++) {
                // Pause for 2 seconds
                Thread.sleep(2000);
                // Print a message
                threadMessage(importantInfo[i]);
            }
        } catch (InterruptedException e) {
            threadMessage("I wasn't done!");
        }
    }
    
    // Display a message, preceded by
    // the name of the current thread
    public static void threadMessage(String message) {
        String threadName = Thread.currentThread().getName();
        System.out.format("%s: %s%n", threadName, message);
    }

}
