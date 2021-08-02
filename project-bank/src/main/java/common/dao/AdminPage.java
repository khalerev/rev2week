package common.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import common.pojo.BankingAcct;
import common.util.DBUtil;

public class AdminPage {
    private static final Logger logger = LogManager.getLogger(DBUtil.class);
	private void adminMenu() {
		System.out.println("::::::::::::::::::::::::::::::::::::");
		System.out.println("Welcome Admin");
		System.out.println("Enter next action: ");
		System.out.println("1. View Customers List");
		System.out.println("2. View Pending Approval");
		System.out.println("3. View Users' Transaction");
		System.out.println("4. Exit");
	}
	
	public void navigateAdmin() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		adminMenu();
		
		System.out.println("Enter Action: ");
		String choice = input.nextLine();
		
		switch (choice) {
			case "1":
				//view accounts
				viewAccounts();
				break;
			case "2":
				//go to pending approval page
				new ApprovalPage().viewApproval();
				break;
			case "3":
				//go to user's transactions
				new TransactionPage().viewTransaction();
				break;
			case "4":
				//go back to home page
				new HomePage().navigateHome();
				break;
		}
	}
	
	private void viewAccounts() {
		try {
			String statement = "select * from banking_account b right outer join customer c on c.cust_id = b.cust_id order by c.lname, c.fname"; 
			
			ResultSet accounts = DBUtil.getInstance().getData(statement);
			List<BankingAcct> bankingAccounts = new ArrayList<BankingAcct>();
			
			while (accounts.next()) {
				bankingAccounts.add(new BankingAcct(accounts));
			}
			
			System.out.println("Name | Customer ID | Account ID | Balance | Is Approved");
			for (BankingAcct a : bankingAccounts) {
				System.out.println(a.getLName() + ", " + a.getFName() + " | " + a.getCustID() + " | " + a.getAcctID() + " | $" + a.getBalance() + " | " + a.isApprove());
			}
		} catch(Exception e) {
			logger.warn("Unable to get database connection",e);
			System.out.println("Error: " + e);
		}
		
		//for pausing before bringing up admin menu again
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Hit any key and enter to exit.");
		input.nextLine();
		navigateAdmin();
	}
}
