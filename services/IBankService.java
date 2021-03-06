package com.cts.BA.services;

import java.util.List;

import com.cts.BA.exception.BankMaintException;
import com.cts.BA.model.Bank;

public interface IBankService {
	
	String add(Bank bk) throws BankMaintException;
	boolean delete(String accountNo) throws BankMaintException;
	Bank get(String accountNo) throws BankMaintException; 
	List<Bank> getAll() throws BankMaintException;
	boolean update(Bank bk) throws BankMaintException;
	void persist() throws BankMaintException;
}
