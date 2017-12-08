package com.alibaba.thread.lock;

public class LiveLock {

    public static void main(String[] args) {

        Person p1 = new Person("Tom");
        Person p2 = new Person("Jack");

        p1.friend = p2;
        p2.friend = p1;
//        p1.bow();
        new Thread(p1).start();
        new Thread(p2).start();
    }
}

class Person implements Runnable {

    String name   = null;
    Person friend = null;

    Person(String name) {
        this.name = name;
    }

    boolean bow = false;
    boolean up  = true;

    public void bow() {
        bow = true;
        up = false;
    }

    public void up() {
        up = true;
        bow = false;
    }

    public void run() {
        while (true) {
            this.bow();
            try {
                System.out.println(name + " 鞠躬...");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.up();
        }
    }
}
