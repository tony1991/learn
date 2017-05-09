package com.alibaba.nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

// buffer类似于io以前的byte[]数组byte[] bytes = new byte[1024];inputStream.read(bytes);
// 注意buffer的三个属性：position，limit，capacity。注意区分compact和clear方法

// channel类似于io里面的inputStream之类的，表示文件的流向，但是是双向的，原先是单向的
// channel两个操作步骤：
// 1.从buffer读写：分散（scatter）读和聚集（gather）写，前者不适合处理动态消息
// scatter / gather经常用于需要将传输的数据分开处理的场合,比如传输消息，你可能会拆分成消息头和消息体分开处理
// 2.通道之间传输：FileChannel的transferFrom()方法可以将数据从源通道传输到FileChannel中；transferTo()方法将数据从FileChannel传输到其他的channel中。

// selector
// why？线程之间上下文切换的开销很大，使用Selector能够用单个线程来处理多个Channels

public class ChannelTest {

    public static void main(String[] args) throws IOException {
        File file = new File("data.txt");
        if (!file.exists()) {
            file.createNewFile();
        } else {
            System.out.println("The new file already exists!");
        }
        FileOutputStream outputStream = new FileOutputStream(file);
        FileChannel channel = outputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        String string = "java nio";
        // buffer写方式有两种（读一样，get），一种是put，另一种是channel。int bytesRead = inChannel.read(buf); //read into buffer.
        buffer.put(string.getBytes());
        buffer.flip(); // 此处必须要调用buffer的flip方法。首先读取数据到Buffer，然后反转Buffer,接着再从Buffer中读取数据。
        channel.write(buffer);
        channel.close();
        outputStream.close();
    }

    public static void fileChannel() throws Exception {
        // 无法直接打开一个FileChannel，需要通过使用一个InputStream、OutputStream或RandomAccessFile
        // 来获取一个FileChannel实例,再打开FileChannel
        RandomAccessFile aFile = new RandomAccessFile("data/nio-data.txt", "rw");
        FileChannel inChannel = aFile.getChannel();
        // 从FileChannel读取数据
        ByteBuffer readBuf = ByteBuffer.allocate(48);
        int bytesRead = inChannel.read(readBuf);
        
        // 向FileChannel写数据
        String newData = "New String to write to file..." + System.currentTimeMillis();
        ByteBuffer writeBuff = ByteBuffer.allocate(48);
        writeBuff.clear();
        writeBuff.put(newData.getBytes());
        writeBuff.flip();
        while (writeBuff.hasRemaining()) {
            inChannel.write(writeBuff);
        }
        //关闭
        inChannel.close();
        
    }
}
