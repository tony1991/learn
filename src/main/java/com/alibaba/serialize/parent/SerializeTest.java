package com.alibaba.serialize.parent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeTest {

    public static void main(String[] args) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("result.obj"));
            out.writeObject(new BMWSerialize("BMW",100L));
            out.close();

            ObjectInputStream oin = new ObjectInputStream(new FileInputStream("result.obj"));
            BMWSerialize bmw = (BMWSerialize) oin.readObject();
            System.out.println("解密后的字符串:" + bmw.getName());
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
