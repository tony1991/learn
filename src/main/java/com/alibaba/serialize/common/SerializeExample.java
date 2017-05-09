package com.alibaba.serialize.common;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * 类SerializeExample.java的实现描述：TODO 类实现描述 
 * @author tony 2015年7月25日 下午3:51:33
 * 要序列化一个对象，首先要创建某些OutputStream(如FileOutputStream、ByteArrayOutputStream等)，
 * 然后将这些OutputStream封装在一个ObjectOutputStream中。这时候，只需要调用writeObject()方法就可以将对象序列化，
 * 并将其发送给OutputStream（对象的序列化是基于字节的，不能使用Reader和Writer等基于字符的层次结构）。
 * 而反序列的过程（即将一个序列还原成为一个对象），
 * 需要将一个InputStream(如FileInputstream、ByteArrayInputStream等)封装在ObjectInputStream内，然后调用readObject()即可。
 * 
 * http://blog.csdn.net/zhaozheng7758/article/details/7820018
 * 序列化保存的是对象的状态，静态变量属于类的状态，因此 序列化并不保存静态变量。
 * 
 */
public class SerializeExample {

    
    public static final String out_file = "src/com/alibaba/serialize/temp.out";

    public static void main(String[] args) {
        User user = new User("tony", 18);
        try {
            //如果这里改成网络输出流而不是文件输出流（反序列化那里也同样改成网络输入流），则可以在网络上传输
            ObjectOutputStream out = new ObjectOutputStream(
                               new BufferedOutputStream(new FileOutputStream(out_file)));
            
            out.writeObject("用户信息..");
            out.writeObject(user);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("序列化完成。请调用反序列化类DeserializeExample完成反序列化！");
        
    }
}
