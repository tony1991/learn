package com.alibaba.thread.consumerAndProducer.apple;


/***
 * 消费者
 **/
public class Consumer extends Thread {

    private Bascket bascket;
    private String  name;

    public Consumer(Bascket bascket, String name) {
        this.bascket = bascket;
        this.name = name;
    }

    public void run() {
        while (true) {
            try {
                System.out.println(name + ":consumer" + bascket.get());
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
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
