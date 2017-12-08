package com.alibaba.thread.base;


/**
 * @author Administrator
 * 演示死锁(不行)；哲学家吃饭问题
 * 解决死锁的问题：把锁的力度加粗
 */
public class DeadLockTest {
	
	public static void main(String[] args){
		DeadLockThread dt1 = new DeadLockThread();
		DeadLockThread dt2 = new DeadLockThread();
		dt1.flag = 1;
		dt2.flag = 0;
		Thread t1 = new Thread(dt1);
		Thread t2 = new Thread(dt2);
		t1.start();
		t2.start();
	}
}
