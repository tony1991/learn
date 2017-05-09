package com.alibaba.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class testHashMap {
	
	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("d", 2);
		map.put("c", 1);
		map.put("b", 1);
		map.put("a", 3);					

		List<Map.Entry<String, Integer>> infoIds =
		    new ArrayList<Map.Entry<String, Integer>>(map.entrySet());

		for (int i = 0; i < infoIds.size(); i++) {
		    String id = infoIds.get(i).toString();
		    System.out.println(id);
		}
		//map不保证插入顺序，根据hashcode插入，输出是:
		//d 2
		//b 1
		//c 1
		//a 3

		Collections.sort(infoIds, new Comparator<Map.Entry<String, Integer>>() { 
		    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {      
		        return (o2.getValue() - o1.getValue()); 
		        //return (o1.getKey()).toString().compareTo(o2.getKey());
		    }
		}); 

		for (int i = 0; i < infoIds.size(); i++) {
		    String id = infoIds.get(i).toString();
		    System.out.println(id);
		}
		//a 3
		//d 2
		//b 1
		//c 1
	}
}
