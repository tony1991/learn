package com.alibaba.thread.executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class FutureCallableTest {

    public static void main(String[] args) {
        futureCallable();
        futureTaskCallable();
    }

    /**
     * futureCallable
     */
    private static void futureCallable() {
        System.out.println("----------futureCallable start----------");
        System.out.println("主线程在执行任务");
        ExecutorService executor = Executors.newCachedThreadPool();
        TaskCallable task = new TaskCallable();
        Future<?> result = executor.submit(task);
        executor.shutdown();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        try {
            System.out.println("task运行结果" + result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("----------futureCallable end----------");
    }

    /**
     * futureTaskCallable
     */
    private static void futureTaskCallable() {
        System.out.println("----------futureTaskCallable start----------");
        System.out.println("主线程在执行任务");
        // 第一种方式
        ExecutorService executor = Executors.newCachedThreadPool();
        TaskCallable task = new TaskCallable();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
        executor.submit(futureTask);
        executor.shutdown();

        // 第二种方式，注意这种方式和第一种方式效果是类似的，只不过一个使用的是ExecutorService，一个使用的是Thread
        /*
         * Task task = new Task(); FutureTask<Integer> futureTask = new FutureTask<Integer>(task); Thread thread = new
         * Thread(futureTask); thread.start();
         */

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        try {
            System.out.println("task运行结果" + futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("----------futureCallable end----------");
    }

}
