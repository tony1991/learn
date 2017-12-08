package com.alibaba.thread.executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * 类ForkJoinTest.java的实现描述：TODO 类实现描述 
 * @author tony 2015年7月28日 下午3:14:50
 * 
 * 利用forkjoin分解任务，计算2+...+10
 */
public class ForkJoinTest extends RecursiveTask<Integer>{
    private static final int THRESHOLD = 2;
    private int start;
    private int end;
    public ForkJoinTest(int start,int end){
        this.start = start;
        this.end = end;
    }
    @Override
    protected Integer compute() {
        int sum = 0;
        //如果任务足够小就计算任务
        boolean canCompute = (end-start)<=THRESHOLD;
        if(canCompute){
            for(int i = start;i<=end;i++){
                sum+=i;
            }
        }else{
            //如果任务大于阈值，就分裂成两个子任务计算
            int middle = (start+end)/2;
            ForkJoinTest leftTask = new ForkJoinTest(start, middle);
            ForkJoinTest rightTask = new ForkJoinTest(middle+1, end);
            //执行子任务,每个子任务在进行fork的时候又会进入computer方法，看是否需要继续分割
            leftTask.fork();
            rightTask.fork();
            //等待子任务执行完并得到其结果
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();
            //合并子任务
            sum = leftResult + rightResult;
        }
        return sum;
    }
    
    public static void main(String[] args) {
        ForkJoinPool fjPool = new ForkJoinPool();
        ForkJoinTest fjTest = new ForkJoinTest(2,10);
        //执行任务
        Future<Integer> result = fjPool.submit(fjTest);
        try{
            System.out.println(result.get());
        }catch(InterruptedException e){
            
        }catch (ExecutionException e) {
            // TODO: handle exception
        }
    }
}
