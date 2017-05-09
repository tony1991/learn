package com.alibaba.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Task implements Runnable {

    private Socket socket;

    public Task(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            handleSocket();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleSocket() throws Exception {
        // 获得客户端的输入流
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        // 获得客户端的输出流
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        String line = in.readLine();
        while (line != null) {
            System.out.println(line);
            out.println("has receive....");
            out.flush();
            line = in.readLine();
        }
        in.close(); // 关闭Socket输出流
        out.close(); // 关闭Socket输入流
        socket.close();
    }
}
