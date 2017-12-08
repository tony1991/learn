package com.alibaba.thread.executor;

import java.util.concurrent.Callable;

public class TaskCallable implements Callable<Integer> {


    @Override
    public Integer call() throws Exception {
        System.out.println("I'm task! I'm counting!");
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += i;
        }
        return sum;
    }

}
