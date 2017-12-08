/**
 * JavaAdvancedDemo 
 * parallel.multithread.sychronized  
 */
package com.alibaba.thread.consumerAndProducer;

/**
 * @author Sheen  2015-7-10
 *
 */
public class Account {
	private String accountNo;
	private double balance;
	
	public Account(){
		
	}
	
	public Account(String accountNo,double balance){
		this.accountNo = accountNo;
		this.balance = balance;
	}
	
	public synchronized void draw(double amount){
		if(balance>amount){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			balance-= amount;
			System.out.println("取钱成功，取款数量:"+amount+",余额:"+balance);
		}else {
			System.out.println("取钱失败，取款数量："+amount+",当前余额:"+balance);
		}
	}
	
	
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public double getBalance() {
		return balance;
	}
}
