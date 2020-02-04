package com.cts.BA.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.cts.BA.exception.BankMaintException;
import com.cts.BA.model.Bank;

public class BankDaoCollectionImpl implements IBankDao {
	
	private Map<String, Bank> banks;
	
	public BankDaoCollectionImpl() {
		banks = new TreeMap<>();
	}
	


	@Override
	public String add(Bank bk) throws BankMaintException {
		String accountNo = null;
		if (bk != null) {
			accountNo = bk.getAccountNo();
			banks.put(accountNo, bk);	
		}
		return accountNo;

	}

	@Override
	public boolean delete(String accountNo) throws BankMaintException {
		boolean isDone = false;
		if (accountNo != null) {
			banks.remove(accountNo);
			isDone = true;
		}
		return isDone;

	}

	@Override
	public Bank get(String accountNo) throws BankMaintException {
		return banks.get(accountNo);
	}

	@Override
	public List<Bank> getAll() throws BankMaintException {
		return new ArrayList<>(banks.values());
	}

	@Override
	public boolean update(Bank bk) throws BankMaintException {
		boolean isDone = false;
		if (bk != null) {
			String accountNo = bk.getAccountNo();
			banks.replace(accountNo, bk);
			
		}
		return isDone;

	}



	@Override
	public void persist() throws BankMaintException {
		//bankDao.persist();
		
	}

}
