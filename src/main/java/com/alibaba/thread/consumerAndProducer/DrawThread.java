/**
 * JavaAdvancedDemo parallel.multithread.sychronized
 */
package com.alibaba.thread.consumerAndProducer;

/**
 * @author Sheen 2015-7-10
 */
public class DrawThread extends Thread {

    private Account account;
    private double  drawAmount;

    public DrawThread() {

    }

    public DrawThread(Account account, double drawAmount) {
        this.account = account;
        this.drawAmount = drawAmount;
    }

    @Override
    public void run() {
        account.draw(drawAmount);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Account act = new Account("3401218888", 1000);
        new DrawThread(act, 800).start();
        new DrawThread(act, 800).start();

    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public double getDrawAmount() {
        return drawAmount;
    }

    public void setDrawAmount(double drawAmount) {
        this.drawAmount = drawAmount;
    }

}
