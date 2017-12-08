package com.alibaba.thread.consumerAndProducer.apple;

import java.util.concurrent.ArrayBlockingQueue;

public class Bascket {
    //共享存储
    ArrayBlockingQueue<Apple> bascket= new ArrayBlockingQueue<>(3);

     public void add(Apple apple) throws InterruptedException{
            if (bascket .size()>=3){
                  System. out .println("add block,please waiting..." );
           }
            bascket.put( apple);
    }
    
     public Apple get() throws InterruptedException{
            if (bascket .size()==0){
                  System. out .println("get block,there is no food..." );
           }
            return (Apple)bascket .take();
    }
}
