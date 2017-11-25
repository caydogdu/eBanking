package com.ingenico.ebanking.account;

/**
 * 
 * @author caydogdu
 * 
 * This is a abstract class for possible accounts
 * 
 */
public abstract class AbstractAccount implements Account {

	protected double balance;
	
    protected String name;

    public AbstractAccount(double balance, String name) { 
    	this.balance = balance;
    	this.name = name;
    }

    public abstract boolean deposit(double amount); 

    public abstract boolean withdraw(double amount);

    public abstract double getBalance();

    public abstract String getName();

}
