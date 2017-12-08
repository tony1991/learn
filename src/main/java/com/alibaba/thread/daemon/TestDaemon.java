package com.alibaba.thread.daemon;

// 守护线程任务

class TestDaemon implements Runnable {

    public void run() {
        try {
//            Thread.sleep(1000);// 守护线程阻塞1秒后运行
//            TestCode.ioCodeInDaemon();   //io逻辑
            // 守护线程计数
            for (int i = 0; i < 999999L; i++) {
                System.out.println("守护（后台）线程 第" + i + "次执行！");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}
