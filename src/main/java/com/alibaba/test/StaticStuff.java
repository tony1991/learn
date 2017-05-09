package com.alibaba.test;

public class StaticStuff {
    static int x = 10;
    static{
        x+=5;
    }
    public static void main(String[] args) {
        System.out.println("X:"+x);
    }
    static{
        x/=3;
    }
}
