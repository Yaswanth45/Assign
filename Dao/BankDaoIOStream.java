package com.cts.BA.Dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.cts.BA.exception.BankMaintException;
import com.cts.BA.model.Bank;

public class BankDaoIOStream implements IBankDao {
	public static final String DATA_STORE_FILE_NAME = "bank.dat";

	private Map<String, Bank> bk;
	public BankDaoIOStream() throws BankMaintException {
		File file = new File(DATA_STORE_FILE_NAME);

		if (!file.exists()) {
			bk = new TreeMap<>();
		} else {
			try (ObjectInputStream fin = new ObjectInputStream(
					new FileInputStream(DATA_STORE_FILE_NAME))) {

				Object obj = fin.readObject();

				if (obj instanceof Map) {
					bk = (Map<String, Bank>) obj;
				} else {
					throw new BankMaintException("Not a valid DataStore");
				}
			} catch (IOException | ClassNotFoundException exp) {
				throw new BankMaintException("Loading Data Failed");
			}
		}
	}
	@Override
	public String add(Bank bk) throws BankMaintException {
		String accountNo = null;
		if (bk != null) {
			accountNo = bk.getAccountNo();
			bk.put(accountNo, bk);	
		}
		return accountNo;

	}

	@Override
	public boolean delete(String accountNo) throws BankMaintException {
		boolean isDone = false;
		if (accountNo != null) {
			bk.remove(accountNo);
			isDone = true;
		}
		return isDone;

	}

	@Override
	public Bank get(String accountNo) throws BankMaintException {
		return bk.get(accountNo);
	}

	@Override
	public List<Bank> getAll() throws BankMaintException {
		return new ArrayList<Bank>(bk.values());
	}

	@Override
	public boolean update(Bank bk) throws BankMaintException {
		boolean isDone = false;
		if (bk != null) {
			String accountNo = bk.getAccountNo();
			bk.replace(accountNo, bk);
		}
		return isDone;
	}
	@Override
	public void persist() throws BankMaintException {
		try (ObjectOutputStream fout = new ObjectOutputStream(
				new FileOutputStream(DATA_STORE_FILE_NAME))) {
			fout.writeObject(bk);
		} catch (IOException exp) {
			throw new BankMaintException("Saving Data Failed");
		}
	}
}
