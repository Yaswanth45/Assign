package com.cts.BA.model;

import java.io.Serializable;
@SuppressWarnings("serial")
public class Bank implements Serializable {
	private String accountNo;
	private String accountName;
	private double balance;
	private String branch;
	public Bank() {
		//default Constructor
	}
	public Bank(String accountNo, String accountName, double balance, String branch) {
		super();
		this.accountNo = accountNo;
		this.accountName = accountName;
		this.balance = balance;
		this.branch = branch;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	@Override
	public String toString() {
		StringBuilder out=new StringBuilder("Accountno :");
		out.append(accountNo);
		out.append("AcoountHolder \t:");
		out.append(accountName);
		out.append("Balance \t:");
		out.append(balance);
		out.append("Branch \t:");
		out.append(branch);
		return out.toString();
	}
	public void replace(String accountNo2, Bank bk) {
		// TODO Auto-generated method stub
		
	}
	public void put(String accountNo2, Bank bk) {
		// TODO Auto-generated method stub
		
	}
	
/*	public int compareTo(Bank bk) {
		String firstBCode = this.accountNo;
		String secondBCode = bk.accountNo;
		return firstBCode.compareTo(secondBCode);
	}

	@Override
	public int hashCode() {
		int hashCode =0;

		char[] chars = accountNo.toCharArray();
		for(int i=1;i<=chars.length;i++){
			hashCode += ((int)chars[i-1])*i;
		}
		
		return hashCode;
	}
	@Override
	public boolean equals(Object obj) {
		boolean flag = false;

		if (obj instanceof Bank) {
			Bank book = (Bank)obj;
			String firstBCode = this.accountNo;
			String secondBCode = book.accountNo;
			flag= firstBCode.equals(secondBCode);
		}
		
		return flag;		
	}*/

	
}
