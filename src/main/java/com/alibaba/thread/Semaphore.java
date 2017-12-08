package com.alibaba.thread;

/**
 * @author Administrator
 *	Take方法发出一个被存放在Semaphore内部的信号，而Release方法则等待一个信号，当其接收到信号后，标记位signal被清空，然后该方法终止。
 *	使用这个semaphore可以避免错失某些信号通知。用take方法来代替notify，release方法来代替wait。
 *	如果某线程在调用release等待之前调用take方法，那么调用release方法的线程仍然知道take方法已经被某个线程调用过了，因为该Semaphore内部保存了take方法发出的信号。
 *	而wait和notify方法就没有这样的功能。当用semaphore来产生信号时，take和release这两个方法名看起来有点奇怪。
 *	这两个名字来源于后面把semaphore当做锁的例子，后面会详细介绍这个例子，在该例子中，take和release这两个名字会变得很合理。
 */
public class Semaphore {
	private boolean signal = false;

	public synchronized void take() {

		this.signal = true;

		this.notify();

	}

	public synchronized void release() throws InterruptedException {

		while (!this.signal)
			wait();

		this.signal = false;

	}
}
