package com.alibaba.classload;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader{
    /* 
     * 覆盖了父类的findClass，实现自定义的classloader
     */
    @Override
    public Class<?> findClass(String name) {
        System.out.println("-------Customer ClassLoader-------");
        byte[] bt = loadClassData(name);
        //使用自定义的类加载器将 byte字节码数组转换为对应的class对象
        return defineClass(name, bt, 0, bt.length);
    }
 
    /**
     * 读取本地的class文件内的字节码，转换成字节码数组
     * @param className
     * @return
     */
    private byte[] loadClassData(String className) {
        // read class
        InputStream is = getClass().getClassLoader().getResourceAsStream(
                className.replace(".", "/") + ".class");
        ByteArrayOutputStream byteSt = new ByteArrayOutputStream();
        // write into byte
        int len = 0;
        try {
            while ((len = is.read()) != -1) {
                byteSt.write(len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // convert into byte array
        return byteSt.toByteArray();
    }
}
