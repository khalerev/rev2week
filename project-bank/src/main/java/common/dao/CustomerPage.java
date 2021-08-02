package common.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import common.pojo.BankingAcct;
import common.pojo.Customer;
import common.util.DBUtil;

public class CustomerPage {
    private static final Logger logger = LogManager.getLogger(DBUtil.class);
	private void customerMenu(String name) {
		System.out.println("::::::::::::::::::::::::::::::::::::");
		System.out.println("Hello " + name + "!");
		System.out.println("What would you like to do today?");
		System.out.println("1. Create Banking Account");
		System.out.println("2. View Banking Account");
		System.out.println("3. Exit");
	}
	
	public void navigateCustomer(Customer customer) {
		customerMenu(customer.getfName());
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter Action: ");
		String choice = input.nextLine();
		
		switch (choice) {
			case "1":
				//createAccount
				createAccount(customer, customer.getCustID());
				break;
			case "2":
				//go to account page
				
				viewAccount(customer);
				break;
			case "3":
				//go back to home page
				new HomePage().navigateHome();
				break;
		}
	}
	
	private void createAccount(Customer customer, int custID) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		System.out.println("How much would you like to deposit in this new account?");
		try {
			double initialDeposit = input.nextDouble();
			
			if (initialDeposit < 0) {
				System.out.println("Initial deposit cannot be less than $0.00");
				createAccount(customer, custID);
			} else {
				String statement = "insert into banking_account (cust_id, balance, is_approve) "
						+ "values(" + custID + ", " + initialDeposit + ", FALSE)";
				
				try {
					DBUtil.getInstance().postData(statement);
					System.out.println("New account is now pending Admin's approval.");
					navigateCustomer(customer);
						
				} catch(Exception e) {
					logger.warn("Unable to get database connection",e);
					System.out.println("Error: " + e);
				}
				
			}
		} catch (Exception e) {
			logger.error("Could not process user input", e);
			System.out.println("Error: " + e.getMessage());
		}
	}

	private void viewAccount(Customer customer) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		
		try {
			String statement = "select * from banking_account b join customer c on c.cust_id = b.cust_id "
					+ "where b.is_approve = TRUE and b.cust_id = " + customer.getCustID(); 
			
			ResultSet accounts = DBUtil.getInstance().getData(statement);
			List<BankingAcct> bankingAccounts = new ArrayList<BankingAcct>();
			
			while (accounts.next()) {
				bankingAccounts.add(new BankingAcct(accounts));
			}
			
			System.out.println("Account ID | Balance");
			for (BankingAcct a : bankingAccounts) {
				System.out.println(a.getAcctID() + " | $" + a.getBalance());
			}
			
			System.out.println("::::::::::::::::::::::::::::::::::::");
			System.out.println("Enter the Account Number you want to view:");
			int accountID = input.nextInt();
			
			List<BankingAcct> filteredList = bankingAccounts.stream()
					.filter(t -> t.getAcctID() == accountID)
					.collect(Collectors .toList());
			
			
			if (filteredList.isEmpty()) {
				System.out.println("Invalid Account, please try again!");
				viewAccount(customer);
			} else {
				new AccountPage().navigateAccount(customer, filteredList.get(0));
			}
			
		} catch (Exception e) {
			logger.error("Could not process user input", e);
			System.out.println("Error: " + e.getMessage());
		}
			
	}
}
