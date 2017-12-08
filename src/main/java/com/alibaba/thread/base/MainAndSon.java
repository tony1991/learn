package com.alibaba.thread.base;



/**
 * @author Administrator
 *  主线程也有可能在子线程结束之前结束。并且子线程不受影响，不会因为主线程的结束而结束。
 *	在java中，每次程序运行至少启动2个线程。一个是main线程，一个是垃圾收集线程。
 *  因为每当使用java命令执行一个类的时候，实际上都会启动一个JVM，每一个JVM实例就是在操作系统中启动了一个进程。
 */
public class MainAndSon {
	
	public static void main(String[] args){
		ThreadOne one = new ThreadOne();
		Thread demo = new Thread(one);
		System.out.println("线程启动之前---》" + demo.isAlive());
        demo.start();
        System.out.println("线程启动之后---》" + demo.isAlive());
	}
}
