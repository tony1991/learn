package com.alibaba.thread.consumerAndProducer.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Producer extends Thread {

    private BufferedReader reader;

    Buffer                 buffer;

    public Producer(Buffer buffer) {
        reader = new BufferedReader(new InputStreamReader(System.in));
        this.buffer = buffer;
    }

    void send(String s) {
        buffer.send(s);
        System.out.println("input string:"+ s);
    }

    public void run() {
        try {
            while (true) {
                String line = reader.readLine();
                send(line);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
