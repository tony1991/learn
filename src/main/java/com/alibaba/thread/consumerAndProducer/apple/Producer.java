package com.alibaba.thread.consumerAndProducer.apple;


/**
 * 生产者
 **/
public class Producer implements Runnable {

    private Bascket bascket;
    private String  name;

    public Producer(Bascket bascket, String name) {
        this.bascket = bascket;
        this.name = name;
    }

    public void run() {
        while (true) {
            try {
                System.out.println(name + " produce..");
                bascket.add(new Apple(" new apple"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }
}
