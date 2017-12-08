package com.alibaba.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    private static int i=1;
    public int getNext(){
         return i++;
    }
    public static void main(String [] args){
//        Test test=new Test();
//        Test testObject=new Test();
//        test.getNext();
//        testObject.getNext();
//        System.out.println(testObject.getNext());
//        System.out.println(4 & 2);

        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        for (String item : list) {
            if ("1".equals(item)) {
                list.remove(item);
            }
        }
//        System.out.println(list);
        Map<String,String> aMap = new HashMap<>();
        aMap.put(null,"1");
        aMap.put(null,"2");
        System.out.println(aMap.get(null));

    }
}
