package com.alibaba.thread.volitile;

public class NoVisibility {

    private static boolean ready;
    private static int     number;

    private static class ReaderThread extends Thread {

        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) throws Exception {
        new ReaderThread().start();
        //下面两行代码执行顺序可能会重排，导致结果出现1（先执行number）或者0（先执行ready），还有可能ready没写入内存导致一直循环
        //可以把这两个变量都加上volitile
        number = 1;
        ready = true;
    }
}
