package com.alibaba.thread.daemon;

/**
 * 类DaemonMain.java的实现描述：TODO 类实现描述 
 * @author tony 2015年7月28日 下午3:01:54
 * 可以一个个注释下面两个方法
 * 守护线程：
 * 一些重要的操作不要放在守护线程里；
 * JRE判断程序是否执行结束的标准是所有的前台执线程行完毕了，而不管后台线程的状态
 * 
 */
public class DaemonMain {

    public static void main(String[] args) throws Exception {
//        testIo();
        testStopTime();
    }

    /**
     * 测试JVM退出时间
     */
    private static void testStopTime() {
        Thread t1 = new CommonThread();
        Thread t2 = new Thread(new TestDaemon());
        t2.setDaemon(true);
        t2.start();
        t1.start();
        /*
         运行结果：
         JRE判断程序是否执行结束的标准是所有的前台执线程行完毕了，而不管后台线程的状态
         */
    }

    /**
     * 测试，读写逻辑是否能放在守护线程里
     */
    private static void testIo() {
        Runnable tr = new TestDaemon();
        Thread daemonTread = new Thread(tr);
        daemonTread.setDaemon(true); // 设置守护线程
        // 验证当前线程是否为守护线程，返回 true 则为守护线程
        System.out.println(daemonTread.isDaemon());
        daemonTread.start(); // 开始执行分进程

        /*
         运行结果：文件daemon.txt都不产生，更不要说文件中有没有"daemon"字符串了。 
         把输入输出逻辑包装进守护线程多么的可怕，原因也很简单，直到主线程完成，守护线程仍处于1秒的阻塞状态。
         这个时候主线程很快就运行完了，虚拟机退出，Daemon停止服务，输出操作自然失败了。
         */
    }
}
