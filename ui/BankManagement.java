package com.cts.BA.ui;

import java.util.List;
import java.util.Scanner;

import com.cts.BA.Dao.BankDaoCollectionImpl;
import com.cts.BA.Dao.BankDaoIOStream;
import com.cts.BA.exception.BankMaintException;
import com.cts.BA.model.Bank;
import com.cts.BA.model.BankAppMenu;
import com.cts.BA.services.BankServiceImpl;
import com.cts.BA.services.IBankService;

public class BankManagement {
	//private static BankDaoCollectionImpl bankService;
	//private static BankDaoIOStream bankService;
	private static Scanner scan;
	private static BankServiceImpl bankService;


	public static void main(String[] args) {
		try {
			bankService = new BankServiceImpl();
		} catch (BankMaintException e) {
			e.printStackTrace();
		}
		BankAppMenu menu = null;

		while (menu != BankAppMenu.QUIT) {
			scan=new Scanner(System.in);
			System.out.println("Choice\tMenu Item");
			System.out.println("===========================");
			for (BankAppMenu m : BankAppMenu.values()) {
				System.out.println(m.ordinal() + "\t" + m.name());
			}
			System.out.print("Choice: ");
			
			int choice =-1;
			if (scan.hasNextInt()) {
				choice = scan.nextInt();
			}
			else {
				scan.next();
				System.out.println("Pleae choose a choice displayed");
				continue;
			}

			if (choice < 0 || choice >= BankAppMenu.values().length) {
				System.out.println("Invalid Choice");
			} else {
				menu = BankAppMenu.values()[choice];
				switch (menu) {
				case ACCOUNT_NUMBER:
					doAdd();
					break;
				case ACCOUNTHOLDERS:
					doList();
					break;
				case SEARCH:
					doSearch();
					break;
				case REMOVE:
					doRemove();
					break;
				case QUIT:
					System.out.println("ThanQ Come Again!");
					break;
				}
			}
		}
		scan.close();
		try {
			bankService.persist();
		} catch (BankMaintException e) {
			e.printStackTrace();
		}

	}
	private static void doAdd() {
		try {
			Bank bk = new Bank();
			System.out.print("AccountNo: ");
			bk.setAccountNo(scan.next());
			System.out.print("AccountHolder: ");
			bk.setAccountName(scan.next());
			System.out.print("Branch ");
			bk.setBranch(scan.next());
//			try {
//				bk.setPublishDate(LocalDate.parse(pubDtStr, dtFormater));
//			} catch (DateTimeException exp) {
//				throw new BookStoreException(
//						"Date must be in the format day(dd)-month(MM)-year(yyyy)");
//			}
			System.out.print("Balance : ");
			if (scan.hasNextDouble())
				bk.setBalance(scan.nextDouble());
			else {
				scan.next();
				throw new BankMaintException("Balance is a number");
			}

			String accountNo = bankService.add(bk);
			System.out.println("Bank Account is Added with Number: " + accountNo);
		} catch (BankMaintException exp) {
			System.out.println(exp.getMessage());
		}
	}

	private static void doList() {
		List<Bank> bk;
		try {
			bk = bankService.getAll();
			if (bk.size() == 0) {
				System.out.println("No Bank Accounts To display");
			} else {
				for (Bank b : bk)
					System.out.println(b);
			}
		} catch (BankMaintException exp) {
			System.out.println(exp.getMessage());
		}
	}

	private static void doSearch() {
		System.out.print("AccountNo: ");
		String accountNo = scan.next();

		try {
			Bank bk = bankService.get(accountNo);
			if (bk != null) {
				System.out.println(bk);
			} else {
				System.out.println("No Such Bank Account");
			}
		} catch (BankMaintException exp) {
			System.out.println(exp.getMessage());
		}
	}

	private static void doRemove() {
		System.out.print("AccountNo : ");
		String accountNo = scan.next();
		try {
			boolean isDone = bankService.delete(accountNo);
			if (isDone) {
				System.out.println("Bank Account is Deleted");
			} else {
				System.out.println("No Such Account");
			}
		} catch (BankMaintException exp) {
			System.out.println(exp.getMessage());
		}
	}


}
