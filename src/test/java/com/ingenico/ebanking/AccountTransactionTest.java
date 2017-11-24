package com.ingenico.ebanking;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ingenico.ebanking.account.Account;
import com.ingenico.ebanking.model.AccountModel;
import com.ingenico.ebanking.model.TransferModel;
import com.ingenico.ebanking.service.AccountTransaction;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
public class AccountTransactionTest {

	private static final Logger logger = LoggerFactory.getLogger(AccountTransactionTest.class);
	
	@Autowired
	private AccountTransaction accountTransaction;
	
	/**
	 * This is a test method to open accounts
	 * @throws Exception
	 */
	@Test
	public void openAccount() throws Exception {

		AccountModel account1 = new AccountModel();
		account1.setBalance(100);
		account1.setName("cemil");
		
		Account acc1 = accountTransaction.openAccount(account1);
		assertEquals("cemil", acc1.getName());
		
		AccountModel account2 = new AccountModel();
		account2.setBalance(150);
		account2.setName("burcu");
		
		accountTransaction.openAccount(account2);
		assertEquals(2, accountTransaction.getAccounts().size());
		
		acc1.withdraw(30);
		assertEquals(70, acc1.getBalance(),0);
		
	}
	
	/**
	 * This is a test method to transfer
	 * @throws Exception
	 */
	@Test
	public void transfer() throws Exception {

		accountTransaction.getAccounts().forEach(
				acc -> logger.info("name: " + acc.getName() + ", balance: " + acc.getBalance()));
		
		TransferModel tm = new TransferModel();
		tm.setNameFrom("cemil");
		tm.setNameTo("burcu");
		tm.setAmount(20);
		
		accountTransaction.transfer(tm);
		
		accountTransaction.getAccounts().forEach(
				acc -> logger.info("name: " + acc.getName() + ", balance: " + acc.getBalance()));

	}
	
	/**
	 * This is a test method to simultaneous transfer
	 * @throws Exception
	 */
	@Test
	public void simultaneousTransfer() throws Exception {
		
	}
	
}