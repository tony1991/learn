package com.alibaba.thread.consumerAndProducer.file;

/**
 * 类PollingBuffer.java的实现描述：TODO 类实现描述 
 * @author tony 2015年8月4日 下午1:56:54
 * 采用轮询的方式，每次都要自己去判断，去查询
 */
public class PollingBuffer implements Buffer{
    String line = null;
    
    @Override
    public void send(String s) {
        //如果输入阻塞，则停一下
        while(line != null){
            pause(1);
        }
        line = s;
    }

    @Override
    public String receive() {
        while(line == null){
            pause(1);
        }
        String s = line;
        line = null;
        return s;
    }

    private void pause(int ms) {
        try {
            Thread.sleep(ms);//由于每次都要暂停，睡眠；多次循环判断，空数据的时候也会这么做，所以效率很低下
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
