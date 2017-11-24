package com.ingenico.ebanking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ingenico.ebanking.account.Account;
import com.ingenico.ebanking.account.CurrentAccount;
import com.ingenico.ebanking.exception.ResponseException;
import com.ingenico.ebanking.model.AccountModel;
import com.ingenico.ebanking.model.TransferModel;

/**
 * 
 * @author caydogdu
 *
 * This is a class for account transactions
 */
@Service
public class AccountTransaction implements Transaction {

	List<Account> accounts = new ArrayList<>();
	
	public Account openAccount(AccountModel acc){
		Account account = new CurrentAccount(acc.getBalance(), acc.getName());
		accounts.add(account);
		return account;
	}
	
	public boolean transfer(TransferModel tm) throws ResponseException{
		Account accountFrom = getAccount(tm.getNameFrom());
		Account accountTo = getAccount(tm.getNameTo());
		if(accountFrom.getBalance() >= tm.getAmount()){
			accountFrom.withdraw(tm.getAmount());
			accountTo.deposit(tm.getAmount());
			return true;
		} else {
			throw new ResponseException("EBanking-01","Balance is not enough to transfer");
		}
	}
	
	public List<Account> getAccounts(){
		return accounts;
	}
	
	public Account getAccount(String name){
		Optional<Account> account = accounts.stream()
				.filter(acc -> acc.getName().equals(name)).findFirst();
		return account.get();
	}
}
