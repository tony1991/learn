package com.alibaba.thread.consumerAndProducer.base;

public class Test {

    public static void main(String[] args) {
        Controller c = new Controller();
        Consumer c1 = new Consumer(c,"c1");
        Consumer c2 = new Consumer(c,"c2");

        Producer p1 = new Producer(c,"p1");
        Producer p2 = new Producer(c,"p2");
        c1.start();
        c2.start();
        p1.start();
        p2.start();
    }
}
