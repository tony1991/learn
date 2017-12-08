package com.alibaba.thread.consumerAndProducer.base;

public class Controller {
    
    int num = 10;
    public  void add(String name) {
        if (num < 15) {
            ++num;
            System.out.println(name + " :producer" + num);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } 
    }
    
    public  void delete(String name) {
        if (num > 0) {
            --num;
            System.out.println(name + " :consumer" + num);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } 
    }
}
