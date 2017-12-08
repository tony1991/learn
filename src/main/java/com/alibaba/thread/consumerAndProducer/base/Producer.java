package com.alibaba.thread.consumerAndProducer.base;

public class Producer extends Thread {

    private String     name;
    private Controller c;

    public Producer(Controller c, String name) {
        this.name = name;
        this.c = c;
    }

    @Override
    public void run() {
        while (true) {
            c.add(name);
        }
    }

}
