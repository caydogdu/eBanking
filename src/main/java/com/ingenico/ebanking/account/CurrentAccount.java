package com.ingenico.ebanking.account;

/**
 * 
 * @author caydogdu
 *
 * This is a class for user current(checking) account
 * 	
 */
public class CurrentAccount extends AbstractAccount {

	public CurrentAccount(double balance, String name) {
		super(balance, name);
	}

	@Override
	public void deposit(double amount) {
		balance += amount;
	}

	@Override
	public void withdraw(double amount) {
		balance -= amount;
	}

	@Override
	public double getBalance() {
		return balance;
	}

	@Override
	public String getName() {
		return name;
	}

}
