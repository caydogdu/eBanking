package com.ingenico.ebanking.account;

/**
 * 
 * @author caydogdu
 *
 */
public interface Account {

	public void deposit(double amount); 

    public void withdraw(double amount);
	
	public double getBalance();

    public String getName();
	
}
