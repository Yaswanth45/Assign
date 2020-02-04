package com.cts.BA.services;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cts.BA.Dao.BankDaoCollectionImpl;
import com.cts.BA.Dao.BankDaoIOStream;
import com.cts.BA.Dao.IBankDao;
import com.cts.BA.exception.BankMaintException;
import com.cts.BA.model.Bank;

public class BankServiceImpl implements IBankService {
	private IBankDao bankDao;

	public IBankDao getDAO(){
		return bankDao;
	}

	public BankServiceImpl() throws BankMaintException {
		//bankDao = new BankDaoCollectionImpl();
		 bankDao = new BankDaoIOStream();
		
	}
	
	public boolean isValidAccountNo(String accountNo){
		
		/*
		 * First letter must be capital
		 * Followed by three digits
		 */
		Pattern bcodePattern = Pattern.compile("[1-9]\\d{5}");
		Matcher bcodeMatcher = bcodePattern.matcher(accountNo);
		
		return bcodeMatcher.matches();
	}
	public boolean isValidAccountHolder(String accountName){
		/*
		 * First Letter should be capital
		 * Minimum length is 4 chars
		 * Maximum length is 20 chars.		
		 */
		Pattern titlePattern = Pattern.compile("[A-Z]\\w{3,10}");
		Matcher titleMatcher = titlePattern.matcher(accountName);
		
		return titleMatcher.matches();
	}
	public boolean isValidBalance(double balance){
		/*
		 * Balance is between 100 and 5000
		 */
		return balance>=100 && balance<=500000;
	}
	public boolean isValidBranch(String branch){
		/*
		 * First Letter should be capital
		 * Minimum length is 4 chars
		 * Maximum length is 20 chars.		
		 */
		Pattern titlePattern = Pattern.compile("[A-Z]\\w{3,10}");
		Matcher branchMatcher = titlePattern.matcher(branch);
		
		return branchMatcher.matches();
	}
	public boolean isValidBank(Bank bk) throws BankMaintException{
		boolean isValid=false;
		
		List<String> errMsgs = new ArrayList<>();
		
		if(!isValidAccountNo(bk.getAccountNo()))
			errMsgs.add("AccountNo should  followed by 10 digits");
		
		if(!isValidAccountHolder(bk.getAccountName()))
			errMsgs.add("Account Holder must start with capital and must be in between 4 to 15 chars in length");
		
		if(!isValidBalance(bk.getBalance()))
			errMsgs.add("Balance must be between INR.5 and INR.500000");
		
		if(!isValidBranch(bk.getBranch()))
			errMsgs.add("Branch should start with a Capital");
		
		if(errMsgs.size()==0)
			isValid=true;
		else
			throw new BankMaintException(errMsgs.toString());
		
		return isValid;
	}


	@Override
	public String add(Bank bk) throws BankMaintException {
		String accountNo=null;
		if(bk!=null && isValidBank(bk)){
			accountNo=bankDao.add(bk);
		}
		return accountNo;
	}


	@Override
	public boolean delete(String accountNo) throws BankMaintException {
		boolean isDone=false;
		if(accountNo!=null && isValidAccountNo(accountNo)){
			bankDao.delete(accountNo);
			isDone = true;
		}else{
			throw new BankMaintException("bcode should be a capital letter followed by 3 digits");
		}
		return isDone;

	}

	@Override
	public Bank get(String accountNo) throws BankMaintException {
		return bankDao.get(accountNo);
	}

	@Override
	public List<Bank> getAll() throws BankMaintException {
		return bankDao.getAll();

	}

	@Override
	public boolean update(Bank bk) throws BankMaintException {
		boolean isDone = false;
		
		if(bk!=null && isValidBank(bk)){
			isDone = bankDao.update(bk);
		}
		
		return isDone;

	}
	@Override
	public void persist() throws BankMaintException {
		bankDao.persist();
	}

}
