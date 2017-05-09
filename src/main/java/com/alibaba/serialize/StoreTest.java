package com.alibaba.serialize;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 类StoreTest.java的实现描述：TODO 类实现描述 
 * @author tony 2015年7月27日 下午11:18:51
 * Java序列化机制为了节省磁盘空间，具有特定的存储规则，当写入文件的为同一对象时，并不会再将对象的内容进行存储，
 * 而只是再次存储一份引用，上面增加的 5字节的存储空间就是新增引用和一些控制信息的空间。
 * 反序列化时，恢复引用关系，使得清单中的 t1和 t2 指向唯一的对象，二者相等，输出 true。该存储规则极大的节省了存储空间。
 */
public class StoreTest implements Serializable{
    private static final long serialVersionUID = 1L;  
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {  
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("result.obj"));  
        StoreTest test = new StoreTest();  
        // 试图将对象两次写入文件  
        out.writeObject(test);  
        out.flush();  
        System.out.println(new File("result.obj").length());  
        out.writeObject(test);  
        out.close();  
        System.out.println(new File("result.obj").length());  
        ObjectInputStream oin = new ObjectInputStream(new FileInputStream("result.obj"));  
        // 从文件依次读出两个文件  
        StoreTest t1 = (StoreTest) oin.readObject();  
        StoreTest t2 = (StoreTest) oin.readObject();  
        oin.close();  
        // 判断两个引用是否指向同一个对象  
        System.out.println(t1 == t2);  
    }  
}
