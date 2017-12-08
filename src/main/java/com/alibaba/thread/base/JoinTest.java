package com.alibaba.thread.base;



/**
 * @author Administrator
 * join；同一个线程对象可以用Thread起多个线程
 */
public class JoinTest {
	
	public static void main(String[] args){
		ThreadTwo t2 = new ThreadTwo();
		ThreadTwo t3 = new ThreadTwo();
		t2.start();
        try{
        	t2.join();
        	t3.start();
        	t3.join();
        }catch(InterruptedException e){
        }
        for(int i=0;i<10;i++){
        	System.out.println("Main Thread");
        }
	}
}
