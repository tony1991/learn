package com.alibaba.thread.base;

/**
 * 类SimpleThreads.java的实现描述：TODO 类实现描述 
 * @author tony 2015年7月30日 上午10:49:00
 * 主线程创建一个MessageLoop线程，如果MessageLoop执行时间过长，主线程会打断
 */
public class SimpleThreads {

    public static void main(String args[]) throws InterruptedException {

        // Delay, in milliseconds before
        // we interrupt MessageLoop 
        // thread (default 5 s).
        long patience = 1000 * 5;

        // If command line argument
        // present, gives patience
        // in seconds.
        if (args.length > 0) {
            try {
                patience = Long.parseLong(args[0]) * 1000;
            } catch (NumberFormatException e) {
                System.err.println("Argument must be an integer.");
                System.exit(1);
            }
        }

        MessageLoop.threadMessage("Starting MessageLoop thread");
        long startTime = System.currentTimeMillis();
        Thread t = new Thread(new MessageLoop());
        t.start();

        MessageLoop.threadMessage("Waiting for MessageLoop thread to finish");
        // loop until MessageLoop
        // thread exits
        while (t.isAlive()) {
            MessageLoop.threadMessage("Still waiting...");
            // Wait maximum of 1 second
            // for MessageLoop thread
            // to finish.
            t.join(1000);
            if (((System.currentTimeMillis() - startTime) > patience) && t.isAlive()) {
                MessageLoop.threadMessage("Tired of waiting!");
                t.interrupt();
                // Shouldn't be long now
                // -- wait indefinitely 不明确
                t.join();
            }
        }
        MessageLoop.threadMessage("Finally!");
    }
}
