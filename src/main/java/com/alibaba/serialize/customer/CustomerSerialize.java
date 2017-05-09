package com.alibaba.serialize.customer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CustomerSerialize {

    public static void main(String[] args) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("result.obj"));
            out.writeObject(new SecurityInfo());
            out.close();

            ObjectInputStream oin = new ObjectInputStream(new FileInputStream("result.obj"));
            SecurityInfo t = (SecurityInfo) oin.readObject();
            System.out.println("解密后的字符串:" + t.getPassword());
            oin.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
