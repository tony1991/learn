package com.alibaba.thread.volitile;

public class Volatile {
	public volatile static int count = 0;

	public static void inc() {
		// 这里延迟1毫秒，使得结果明显
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
		}
		count++;
	}

	public static void main(String[] args) {
		// 同时启动100个线程，去进行i++计算，看看实际结果
		for (int i = 0; i < 100; i++) {
			new Thread(new Runnable() {
				public void run() {
					Volatile.inc();
				}
			}).start();
			// 这里每次运行的值都有可能不同,可能不为1000
			System.out.println("i:" +i+"   "+ Volatile.count);
		}
		// 这里每次运行的值都有可能不同,可能不为1000
		System.out.println("运行结果:Counter.count=" + Volatile.count);
	}
}
