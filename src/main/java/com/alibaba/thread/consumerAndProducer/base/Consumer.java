package com.alibaba.thread.consumerAndProducer.base;

public class Consumer extends Thread {

    private String     name;
    private Controller c;

    public Consumer(Controller c, String name) {
        this.name = name;
        this.c = c;
    }

    @Override
    public void run() {
        while (true) {
            c.delete(name);
        }
    }
}
