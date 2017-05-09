package com.alibaba.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 类MapTest.java的实现描述：TODO 类实现描述 
 * @author tony 2015年9月7日 上午11:22:33
 * 1.HashMap里面存入的键值对在取出的时候是随机的,它根据键的HashCode值存储数据,根据键可以直接获取它的值，具有很快的访问速度。
 * 2.TreeMap取出来的是排序后的键值对，默认升序。
 * 3.LinkedHashMap是HashMap的一个子类，按照输入顺序输出。
 */
public class MapTest {

    public static void main(String[] args) {
        compareThreeMapOutput();
    }

    private static void compareThreeMapOutput() {
        // HashMap
        System.out.println("------HashMap无序输出------");
        HashMap<String,String> hsMap = new HashMap<String,String>();
        hsMap.put("3", "Value3");
        hsMap.put("1", "Value1");
        hsMap.put("2", "Value2");
        hsMap.put("b", "ValueB");
        hsMap.put("a", "ValueA");
        Iterator it = hsMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry) it.next();
            System.out.println("Key: " + e.getKey() + "--Value: " + e.getValue());
        }
        // TreeMap
        System.out.println("------TreeMap按Key排序输出------");
        TreeMap<String,String> teMap = new TreeMap<String,String>();
        teMap.put("3", "Value3");
        teMap.put("1", "Value1");
        teMap.put("2", "Value2");
        teMap.put("b", "ValueB");
        teMap.put("a", "ValueA");
        Iterator tit = teMap.entrySet().iterator();
        while (tit.hasNext()) {
            Map.Entry e = (Map.Entry) tit.next();
            System.out.println("Key: " + e.getKey() + "--Value: " + e.getValue());
        }
        // LinkedHashMap
        System.out.println("--LinkedHashMap根据输入的顺序输出--");
        LinkedHashMap<String,String> lhsMap = new LinkedHashMap<String,String>();
        lhsMap.put("3", "Value3");
        lhsMap.put("1", "Value1");
        lhsMap.put("2", "Value2");
        lhsMap.put("b", "ValueB");
        lhsMap.put("a", "ValueA");
        Iterator lit = lhsMap.entrySet().iterator();
        while (lit.hasNext()) {
            Map.Entry e = (Map.Entry) lit.next();
            System.out.println("Key: " + e.getKey() + "--Value: " + e.getValue());
        }
    }
}
