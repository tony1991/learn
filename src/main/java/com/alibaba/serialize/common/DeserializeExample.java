package com.alibaba.serialize.common;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeserializeExample {
    public static void main(String[] args) throws Exception{
            ObjectInputStream in = new ObjectInputStream(
                               new BufferedInputStream(new FileInputStream(SerializeExample.out_file)));
            String title = (String) in.readObject();
            System.out.println(title);
            User user = (User) in.readObject();
            System.out.println("用户姓名："+user.getUsername());
            System.out.println("用户年龄："+user.getAge());
    }
}
