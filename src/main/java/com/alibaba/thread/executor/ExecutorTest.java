package com.alibaba.thread.executor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.alibaba.thread.base.RunableTest;

public class ExecutorTest {

    private final static int THREAD_POOL_SIZE = 2;

    private static final int PUT_QUEUE_SIZE   = 100;

    public static void main(String[] args) {
        test1();
        // test2();
    }

    /**
     * 创建固定数目线程的线程池
     */
    private static void test1() {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executor.submit(new RunableTest());
        }
        executor.shutdown();
    }

    /**
     * 创建一个支持定时及周期性的任务执行的线程池，多数情况下可用来替代Timer类
     */
    private static void test2() {
        Executor executor = Executors.newScheduledThreadPool(10);
        ScheduledExecutorService scheduler = (ScheduledExecutorService) executor;
        scheduler.scheduleAtFixedRate(new RunableTest(), 10, 10, TimeUnit.SECONDS);
    }

    private static void test3() {
        ExecutorService executorService = new ThreadPoolExecutor(THREAD_POOL_SIZE, THREAD_POOL_SIZE * 2, 1000L,
                                                                 TimeUnit.MILLISECONDS,
                                                                 new ArrayBlockingQueue<Runnable>(PUT_QUEUE_SIZE),
                                                                 new ThreadPoolExecutor.DiscardPolicy());
        
        /*
        corePoolSize    指保留的线程池大小
        maximumPoolSize 指的是线程池的最大大小
        keepAliveTime   指的是空闲线程结束的超时时间（keepAliveTime时间后将停止该线程）
        unit    枚举，是keepAliveTime的单位（有NANOSECONDS, MICROSECONDS, MILLISECONDS, SECONDS, MINUTES, HOURS, DAYS，7个可选值）
        workQueue   表示存放任务的队列（存放需要被线程池执行的线程队列）
        handler 拒绝策略（添加任务失败后如何处理该任务）
        
        1. 如果正在运行的线程数量小于 corePoolSize，那么马上创建线程运行这个任务；
        2. 如果正在运行的线程数量大于或等于 corePoolSize，那么将这个任务放入队列。
        3. 如果这时候队列满了，而且正在运行的线程数量小于 maximumPoolSize，那么还是要创建线程运行这个任务；
        4. 如果队列满了，而且正在运行的线程数量大于或等于 maximumPoolSize，那么线程池会抛出异常，告诉调用者“我不能再接受任务了”。
        */
    }
}
