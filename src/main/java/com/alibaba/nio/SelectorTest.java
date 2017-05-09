package com.alibaba.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/*
 * 四类事件：Connect、Accept、Read、Write
 */
public class SelectorTest {

    public static void main(String[] args) throws IOException {
        selectorTest();
    }

    /**
     * 该方法将监听请求和处理请求的事件放到一块了
     * @throws IOException
     */
    private static void selectorTest() throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        // 调用Selector的静态工厂创建一个选择器
        Selector selector = Selector.open();
        //创建一个服务端的Channel
        ServerSocketChannel channel = ServerSocketChannel.open();
        // 向Selector注册通道。注意与Selector一起使用时，Channel必须处于非阻塞模式下。
        // 这意味着不能将FileChannel与Selector一起使用，因为FileChannel不能切换到非阻塞模式。
        channel.configureBlocking(false);
        channel.socket().bind(new InetSocketAddress(8080));
        channel.register(selector, SelectionKey.OP_READ);
        while (true) {
            //检查已经注册在这个选择器上的所有通信信道是否有需要的事件发生
            Set selectedKeys = selector.selectedKeys();//取得所有key集合
            Iterator it = selectedKeys.iterator();
            while (it.hasNext()) {
                SelectionKey key = (SelectionKey) it.next();
                /*
                if(key.isAcceptable()) {  
                    // a connection was accepted by a ServerSocketChannel.  
                } else if (key.isConnectable()) {  
                    // a connection was established with a remote server.  
                } else if (key.isReadable()) {  
                    // a channel is ready for reading  
                } else if (key.isWritable()) {  
                    // a channel is ready for writing  
                }  
                */
                if (key.isAcceptable()) {
                    ServerSocketChannel ssChannel = (ServerSocketChannel) key.channel();//转型成你要处理的类型
                    SocketChannel sc = ssChannel.accept();//接受到服务端的请求
                    sc.configureBlocking(false);
                    sc.register(selector, SelectionKey.OP_READ);
                } else if(key.isReadable()) {
                    SocketChannel sc = (SocketChannel) key.channel();//转型成你要处理的类型
                    while (true) {
                        buffer.clear();
                        int n = sc.read(buffer);//读取数据
                        //如果返回的是-1，表示已经读到了流的末尾
                        if (n <= 0) {
                            break;
                        }
                        buffer.flip();
                    }
                }
                //Selector不会自己从已选择键集中移除SelectionKey实例。
                //必须在处理完通道时自己移除。下次该通道变成就绪时，Selector会再次将其放入已选择键集中。 
                it.remove();
            }
        }
    }

}
