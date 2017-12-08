package com.alibaba.thread.base;

/**
 * @author Administrator
 */
public class ThreadOne implements Runnable{

	public void run() {
		System.out.println(Thread.currentThread().getName()+"正在执行。。。。");
	}
}
