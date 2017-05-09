package com.alibaba.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class CreateObj implements Cloneable,Serializable{

    private static String filename = CreateObj.class.getResource("").getPath() + "/obj.txt";
    static File file = new File(filename);
    static {
        if (!file.exists()) try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        // 1.第一种常用方式
        CreateObj s1 = new CreateObj();
        System.out.println(s1);
        // 2.第二种方式 静态方式 java.lang.InstantiationException
        CreateObj s2 = (CreateObj) Class.forName("com.alibaba.base.CreateObj").newInstance();
        System.out.println(s2);
        // 第三种方式 用对象流来实现前提是对象必须实现 Serializable
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename));
        objectOutputStream.writeObject(s2);
        ObjectInput input = new ObjectInputStream(new FileInputStream(filename));
        CreateObj s3 = (CreateObj) input.readObject();
        System.out.println(s3);
        // 第四种 clone 必须 实现Cloneable接口 否则抛出CloneNotSupportedException
        CreateObj obj = new CreateObj();
        CreateObj s4 = (CreateObj) obj.clone();
        System.out.println(s4);
    }
}
