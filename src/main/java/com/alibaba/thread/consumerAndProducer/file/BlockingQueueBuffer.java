package com.alibaba.thread.consumerAndProducer.file;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 类BlockingQueueBuffer.java的实现描述：TODO 类实现描述 
 * @author tony 2015年8月5日 下午8:50:38
 * 最佳的实现方式
 * 解决了生产速度
 */
public class BlockingQueueBuffer implements Buffer {
    BlockingQueue<String> queue;
    
    public BlockingQueueBuffer (int capacity) {
        queue = new ArrayBlockingQueue<String>(capacity);
    }
    
    @Override
    public void send(String s) {
        try {
            queue.put(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String receive() {
        try {
            return queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

}
