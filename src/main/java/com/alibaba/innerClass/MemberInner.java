package com.alibaba.innerClass;

/**
 * 类MemberInner.java的实现描述：TODO 类实现描述 
 * @author tony 2015年9月21日 下午7:38:10
 * 
 * 
 */
public class MemberInner {
    private double radius = 0;
    public static int count =1;
    
    public MemberInner(double radius) {
        this.radius = radius;
    }
     
    class Draw {     
        //成员内部类可以无条件访问外部类的所有成员属性和成员方法（包括private成员和静态成员）。
        public void drawSahpe() {
            System.out.println(radius);  //外部类的private成员
            System.out.println(count);   //外部类的静态成员
        }
    }
}
