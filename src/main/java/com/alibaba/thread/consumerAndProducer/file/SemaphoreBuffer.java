package com.alibaba.thread.consumerAndProducer.file;

import java.util.concurrent.Semaphore;

/**
 * 类SemaphoreBuffer.java的实现描述：TODO 类实现描述 
 * @author tony 2015年8月5日 下午8:49:21
 * 通过信号量通知生产者和消费者
 * 对新手难以理解
 */
public class SemaphoreBuffer implements Buffer {

    String    line;
    Semaphore full;
    Semaphore empty;

    public SemaphoreBuffer(){
        full = new Semaphore(1);
        empty = new Semaphore(1);
    }
    
    @Override
    public void send(String s) {
        try{
            full.acquireUninterruptibly();
            line = s;
        }
        finally{
            empty.release();
        }
    }

    @Override
    public String receive() {
        try{
            empty.acquireUninterruptibly();
            return line;
        }
        //清空消息队列
        finally{
            full.release();
            line = null;
        }
    }
}
