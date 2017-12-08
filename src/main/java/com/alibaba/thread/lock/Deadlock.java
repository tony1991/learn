package com.alibaba.thread.lock;

/**
 * 类Deadlock.java的实现描述：TODO 类实现描述 
 * @author tony 2015年7月30日 上午11:26:38
 * 演示死锁
 */
public class Deadlock {

    static class Friend {

        private final String name;

        public Friend(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public synchronized void bow(Friend bower) {
            System.out.format("%s: %s" + "  has bowed to me!%n", this.name, bower.getName());
            //调用bower对象的bowBack方法，由于该方法是同步方法，因此会试图获取bower对象的对象锁
            //传入的是哪个对象，就获取哪个对象的锁
            bower.bowBack(this);
        }

        public synchronized void bowBack(Friend bower) {
            System.out.format("%s: %s" + " has bowed back to me!%n", this.name, bower.getName());
        }
    }

    public static void main(String[] args) {
        final Friend alphonse = new Friend("Alphonse");
        final Friend gaston = new Friend("Gaston");
        
        new Thread(new Runnable() {

            public void run() {
                alphonse.bow(gaston);//传入的是gaston对象
            }
        }).start();
        
        new Thread(new Runnable() {

            public void run() {
                gaston.bow(alphonse);//传入的是alphonse对象
            }
        }).start();
    }
}
