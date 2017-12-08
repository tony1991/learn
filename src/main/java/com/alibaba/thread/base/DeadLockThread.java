package com.alibaba.thread.base;

/**
 * @author Administrator
 * 演示死锁
 */
public class DeadLockThread implements Runnable{
	public int flag = 1;
	static Object o1 = new Object(),o2 = new Object(); 
	public void run() {
		System.out.println("flag:"+flag);
		if(flag==1){
			synchronized(o1){
				try{
					Thread.sleep(100);
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			synchronized(o2){
				System.out.println("1");
			}
		}
		
		if(flag==0){
			synchronized(o2){
				try{
					Thread.sleep(100);
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			synchronized(o1){
				System.out.println("0");
			}
		}
	}
}
