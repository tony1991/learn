package com.alibaba.thread.consumerAndProducer.file;

/**
 * 类WaitNotifyBuffer.java的实现描述：TODO 类实现描述 
 * @author tony 2015年8月4日 下午1:57:40
 * wait，notify
 * 我自己不判断，有数据的时候通知我
 * 但是代码难写难读，容易出现Exception
 */
public class WaitNotifyBuffer implements Buffer {

    String line;

    @Override
    public synchronized void send(String s) {   //注意这里加了个synchronized
        if (line != null) {
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        line = s;
        notify();
    }

    @Override
    public synchronized String receive() {
        if (line == null) {
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        String s = line;
        line = null;
        notify();
        return s;
    }
}
