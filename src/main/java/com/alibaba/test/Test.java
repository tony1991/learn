package com.alibaba.test;

public class Test {
    private static int i=1;
    public int getNext(){
         return i++;
    }
    public static void main(String [] args){
        Test test=new Test();
        Test testObject=new Test();
        test.getNext();
        testObject.getNext();
        System.out.println(testObject.getNext());
        System.out.println(4&2);
    }
}
