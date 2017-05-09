package com.alibaba.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TalkServer {

    public static void main(String[] args) throws Exception {
        System.out.println("server start!");
        ServerSocket server = new ServerSocket(9999);
        Socket client = server.accept();
        //获得客户端的输入流
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        //获得客户端的输出流
        PrintWriter out = new PrintWriter(client.getOutputStream());
        String line = in.readLine();
        
        while(line!=null){
            System.out.println(line);
            out.println("has receive....");
            out.flush();
            line = in.readLine();
        }
        in.close(); //关闭Socket输出流
        out.close(); //关闭Socket输入流
        client.close();
        server.close(); //关闭ServerSocket
    }
}
