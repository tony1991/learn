package com.alibaba.thread.consumerAndProducer.file;

public interface Buffer {
    public void send(String s);
    public String receive();
}
