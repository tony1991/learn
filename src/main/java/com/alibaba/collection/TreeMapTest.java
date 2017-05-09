package com.alibaba.collection;

import java.util.TreeMap;

public class TreeMapTest {
	public static void main(String[] args) {
		test1();
	}
	public static void test1(){
		TreeMap<Object,String> t = new TreeMap<Object,String>();
		t.put(2, "b");
		t.put(1, "a");
		System.out.println(t);
	}
}
