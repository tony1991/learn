package com.alibaba.thread.consumerAndProducer.file;

public class FileTest {
    public static void main(String[] args) {
        pEqualsC();
    }

    private static void pEqualsC() {
      //这里可以采用多种方式来控制同步
        Buffer buffer = new PollingBuffer();
//        Buffer buffer = new WaitNotifyBuffer();
        Producer p = new Producer(buffer);
        Consumer c = new Consumer(buffer);
        p.start();
        c.start();
    }
}
