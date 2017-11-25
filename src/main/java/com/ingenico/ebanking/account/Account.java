package com.ingenico.ebanking.account;

/**
 * 
 * @author caydogdu
 *
 */
public interface Account {

	public boolean deposit(double amount); 

    public boolean withdraw(double amount);
	
	public double getBalance();

    public String getName();
	
}
