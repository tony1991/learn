package com.alibaba.thread.daemon;

import java.io.File;
import java.io.FileOutputStream;

public class TestCode {

    /**
     * 往文件写内容
     * 
     * @throws Exception
     */
    public static void ioCodeInDaemon() throws Exception {
        File file = new File("test.txt");// 相对路径
        if (!file.exists()) {
            file.createNewFile();
        } else {
            System.out.println("The new file already exists!");
        }
        // 打印文件绝对路径和相对路径
        System.out.println(file.getCanonicalPath());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getPath());
        // 往文件写内容
        FileOutputStream os = new FileOutputStream(file, true);
        os.write("daemon".getBytes());
    }

}
