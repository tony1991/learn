package com.alibaba.thread.base;

/**
 * @author Administrator
 */
public class ThreadTwo extends Thread{

	public void run() {
		for(int i=0;i<5;i++){
			System.out.println(Thread.currentThread().getName()+i);
			try{
				sleep(1000);
			}catch(InterruptedException e){
				return ;
			}
		}
	}
}
