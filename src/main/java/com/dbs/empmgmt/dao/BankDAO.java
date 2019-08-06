package com.dbs.empmgmt.dao;

import java.util.List;

import com.dbs.empmgmt.model.BankAccount;

public interface BankDAO {
	BankAccount save(BankAccount bankaccount);
	
	BankAccount update(long empId, BankAccount bankaccount);
	
	List<BankAccount> findAll();

	BankAccount findById(long id);

	void deleteBankAccount(long id);

}
