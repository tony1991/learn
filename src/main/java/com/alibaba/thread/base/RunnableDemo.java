package com.alibaba.thread.base;

public class RunnableDemo {

    public static void main(String[] args) {
        RunableTest r = new RunableTest();
        Thread P1 = new Thread(r,"A");
        Thread P2 = new Thread(r,"B");
        P1.start();
        P2.start();
    }
}
