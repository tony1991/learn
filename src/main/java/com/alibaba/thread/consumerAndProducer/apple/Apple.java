package com.alibaba.thread.consumerAndProducer.apple;

public class Apple {

    private String appName;

    public Apple(String appName) {
        this.appName = appName;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String toString() {
        return this.appName;
    }
}
