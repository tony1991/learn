package com.alibaba.thread.consumerAndProducer.file;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Consumer extends Thread{

    private BufferedWriter writer;
    Buffer                 buffer;

    public Consumer(Buffer buffer) {
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
        this.buffer = buffer;
    }
    
    public String receive(){
        return buffer.receive();
    }
    
    public void run(){
        while(true){
            String line = receive();
            System.out.println("接收到的数据为:");
            if(line != null){
                try{
                    writer.write(line);
                    writer.flush();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
