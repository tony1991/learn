package com.alibaba.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 一些初学者容易忽视的坑
 * 类Careful.java的实现描述：TODO 类实现描述 
 * @author tony 2015年9月8日 下午8:11:25
 */
public class Careful {
    
    long a[] = new long[10];
    
    public final double i = Math.random();
    public static double j = Math.random();
    
    public static void main(String[] args) {
        //System.out.println ( a[6] );这句话会报错，a需要static
        iPlusPlus();
        stringEquals();
        tryCatchFinally();
        finalTest(3);
        createArray();
        booleanJudge();
        canshu();
        substringTest();
        ;;;//注意，这不是语法错误
        int x=1;
        int y=2;
        String a = "a";
        String b = "b";
        int[] list = {5,6,7};
        swapIntParam(x,y);
        swapIntParam(list[0],list[1]);
        swapStringParam(a,b);
        System.out.println(x+" "+y+" "+a+" "+b+" "+list[0]+" "+list[1]);
        
        Careful myClass1 = new Careful();
        Careful myClass2 = new Careful();
        System.out.println(myClass1.i);
        System.out.println(myClass1.j);
        System.out.println(myClass2.i);
        System.out.println(myClass2.j);
        
//        foreachTest();
        System.out.println(finallyTestInt());
    }

    private static void foreachTest() {
        List<String> list = new ArrayList<String>();
        list.add("aa");
        for(String aid:list){
            if(aid.equals("aa")){
             list.remove(aid);  //这行会报错，不能修改list的长度
            }
         }
    }

    private static void swapIntParam(int x,int y) {
        int z = x;
        x = y;
        y = z;
    }
    
    private static void swapStringParam(String a,String b) {
        String c = a;
        a = b;
        b = c;
    }

    private static void substringTest() {
        String s = new String("Bicycle");
        int iBegin = 1;
        char iEnd = 3;
        System.out.println(s.substring(iBegin, iEnd));//这里char不会报错，会转成int
    }

    private static void canshu() {
        int i= 99;
        mb_operate(i);
        System.out.println(i+100);//输出为199
        
        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        mb_operate(a, b);
        System.out.println(a + "." + b);//输出为AB.B
    }

    private static void mb_operate(StringBuffer x, StringBuffer y) {
        x.append(y);
        y=x;
    }

    private static void mb_operate(int i) {
        i+=100;
    }

    private static void booleanJudge() {
        boolean m = true;
        if(m = false)//这里不会报错
            System.out.println("False");
        else
            System.out.println("True");
    }

    private static void createArray() {
        float []f1[] = new float[6][6];
//        float f2[][] = new float[][6]; this is wrong
        float [][]f3 = new float[6][6];
        float [][]f4 = new float[6][];
    }

    private static void finalTest(final int a) {
//        a = 2;加上这句会报错
        System.out.println(a);
    }

    private static void stringEquals() {
        String a = "Programming";
        String b = new String("Programming");
        String c = "Program" + "ming";
        
        int i = 5;
        Integer j = new Integer("5");
        
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
        System.out.println(a.intern() == b.intern());
        System.out.println(i==j);
    }

    private static void iPlusPlus() {
        int i=0;
        System.out.println("i++:"+i++);
        System.out.println("i:"+i);
        System.out.println("--i:"+--i);
        System.out.println("i:"+i);
        i=1;
        int j=10;
        do{
            if(i++ > --j) 
                continue;
        }while(i<5);
        System.out.println("i:"+i);
        System.out.println("j:"+j);
    }

    /**
     * 注意区分基本类型和引用类型
     */
    private static void tryCatchFinally() {
        String result = finallyTest();
        System.out.println(result);
        Map<String, String> aMap = new HashMap<String, String>();
        aMap = finallyTest2();
        System.out.println(aMap.get("key"));
    }

    private static Map<String, String> finallyTest2() {
        Map<String, String> aMap = new HashMap<String, String>();
        aMap.put("key", "value");
        try {
            return aMap;
        } catch (Exception e) {

        } finally {
            aMap.put("key", "value1");
        }
        return null;

    }

    private static String finallyTest() {
        String a = "a";
        try {
            return a;
        } catch (Exception e) {

        } finally {
            a = "b";
        }
        return null;
    }
    
    public static int finallyTestInt (){
        try{
            return 1;
        }catch (Exception e){
            return 2;
        }finally{
            return 3;
        }
    }
}
