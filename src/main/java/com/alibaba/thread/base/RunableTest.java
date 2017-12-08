package com.alibaba.thread.base;

public class RunableTest implements Runnable {

    public static int count = 0;

    @Override
    public void run() {
        char a = 12;
        while(true){
            try{
                if (count < 100) {
                    System.out.println(Thread.currentThread().getName() + "=..." + count++);
                    this.notify();
                    this.wait();
                }
            }catch(Exception e){
                
            }
        }
    }

}
