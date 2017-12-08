package com.alibaba.thread.consumerAndProducer.apple;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 生产者，消费者测试
 * 
 * **/
public class BlockingQueueTest {
    
    public static void main(String[] args) {
        
        Bascket bascket= new Bascket();
        Consumer c1= new Consumer(bascket ,"c1" );
        Consumer c2= new Consumer(bascket ,"c2" );
        
        Producer p1= new Producer(bascket ,"p1" );
        Producer p2= new Producer(bascket ,"p2" );
//        Producer p3= new Producer(bascket ,"p3" );
        
         //线程池管理
        ExecutorService service = Executors. newCachedThreadPool();
        //这里注意一下，consumer放在前面的话，可以看到运行结果里面一开始消费是阻塞的，
        //但时间一长，就会生产速度会和消费速度一致
        service.execute(p1);
        service.execute(p2);   
        service.execute(c1);
        service.execute(c2);
//        service.execute(p3);        
    }

}
