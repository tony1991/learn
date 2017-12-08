package com.alibaba.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 类ConcurrentHashMapTest.java的实现描述：TODO 类实现描述
 * 
 * @author tony 2015年7月28日 下午3:10:52 测试concurrentHashMap的遍历和删除
 */
public class ConcurrentHashMapTest {

    public static void main(String[] args) {

        ConcurrentHashMap<String, Object> cMap = new ConcurrentHashMap<String, Object>();
        cMap.put("1", 1);
        cMap.put("2", 2);
        cMap.put("3", 3);
        cMap.put("4", 4);
        for (ConcurrentHashMap.Entry<String, Object> c : cMap.entrySet()) {
            System.out.println("键:" + c.getKey() + ", 值:" + c.getValue());
        }
        cMap.remove("3");
        for (ConcurrentHashMap.Entry<String, Object> c : cMap.entrySet()) {
            System.out.println("键:" + c.getKey() + ", 值:" + c.getValue());
        }

        // 并发编程中对随机数的生成，尽量采用ThreadLocalRandom
        int r = ThreadLocalRandom.current().nextInt(4, 77);
        System.out.println("r:" + r);

        //
        //Map<String, String> mapTest = new HashMap<String, String>();

    }
}
