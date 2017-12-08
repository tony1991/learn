package com.alibaba.thread.volitile;


public class Count {

    private volatile int i = 0;
    
    public void increase(){
        i++;
    }
    
    public int getValue(){
        return i;
    }
}
