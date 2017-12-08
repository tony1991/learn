package com.alibaba.thread.daemon;

public class CommonThread extends Thread {

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("前台线程 第" + i + "次执行！");
            try {
                Thread.sleep(7);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
