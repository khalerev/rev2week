package common.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import common.pojo.BankingAcct;
import common.pojo.Customer;
import common.pojo.PendingTransfer;
import common.util.DBUtil;

public class AccountPage {

    private static final Logger logger = LogManager.getLogger(DBUtil.class);
	private void accountMenu(String custName, BankingAcct account) {
		System.out.println("::::::::::::::::::::::::::::::::::::");
		System.out.println(custName + " - " + account.getAcctID());
		System.out.println("Current Balance: " + account.getBalance());
		System.out.println("::::::::::::::::::::::::::::::::::::");
		System.out.println("1. Deposit Money");
		System.out.println("2. Withdraw Money");
		System.out.println("3. Transfer to Another Account");
		System.out.println("4. View Pending Transfer");
		System.out.println("5. Exit");
	}
	
	public void navigateAccount(Customer customer, BankingAcct account) {
		
		accountMenu(customer.getfName(), account);
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter Action: ");
		String choice = input.nextLine();
		
		switch (choice) {
			case "1":
			case "2":
				//deposit or withdraw money
				depositOrWithdraw(customer, account, choice);
				break;
			case "3":
				//transfer to another account
				initiateTransfer(customer, account);
				break;
			case "4":
				//view pending transfer
				viewPendingTransfer(customer, account);
			case "5":
				//exiting - going back to customer page
				new CustomerPage().navigateCustomer(customer);
				break;
		}
	}
	
	private void depositOrWithdraw(Customer customer, BankingAcct account, String choice) {
		@SuppressWarnings("resource")
		Scanner amount = new Scanner(System.in);
		Double transAmount = 0.0;
		
		try {
			if (choice.equals("1")) {
				System.out.println("Deposit amount: ");
				transAmount = amount.nextDouble();
				
				if (transAmount > 0) {
					String statement = "update banking_account set balance = balance + " + transAmount + " where acct_id = " + account.getAcctID() + ";"
							+" insert into transaction (acct_id, amount, trans_type, time_stamp) values("+account.getAcctID()+","
							+transAmount+",'deposit','"+ new Timestamp(new Date().getTime())+"');";
					DBUtil.getInstance().postData(statement);
					statement = "select * from banking_account where acct_id = " + account.getAcctID() + ";";
					ResultSet balance = DBUtil.getInstance().getData(statement);
					balance.next();
					account.setBalance(balance.getDouble(3));
				} else {
					System.out.println("Invalid deposit amount, try again");
				}
				navigateAccount(customer, account);
				
			} else {
				System.out.println("Withdraw amount: ");
				transAmount = amount.nextDouble();
				
				if (transAmount > 0 && transAmount <= account.getBalance()) {
					
					String statement = "update banking_account set balance = balance - " + transAmount + " where acct_id = " + account.getAcctID() + ";"
							+" insert into transaction (acct_id, amount, trans_type, time_stamp) values("+account.getAcctID()+","
							+transAmount+",'withdraw','"+ new Timestamp(new Date().getTime())+"');";
					DBUtil.getInstance().postData(statement);
					statement = "select * from banking_account where acct_id = " + account.getAcctID() + ";";
					ResultSet balance = DBUtil.getInstance().getData(statement);
					balance.next();
					account.setBalance(balance.getDouble(3));
				} else {
					System.out.println("Invalid deposit amount, try again.");
				}
				navigateAccount(customer, account);
			}
		}
		catch (Exception e) {
			logger.warn("Unable to get database connection",e);
			System.out.println("Error: " + e);
		}
	}
	
	private void initiateTransfer(Customer customer, BankingAcct account) {
		@SuppressWarnings("resource")
		Scanner transferInput = new Scanner(System.in);
		try {
			System.out.println("Transfer amount: ");
			Double transAmount = transferInput.nextDouble();
			
			if (transAmount > 0 && transAmount <= account.getBalance()) {
				
				System.out.println("Enter the account number you wish to transfer to: ");
				int receiverID = transferInput.nextInt();
				
				System.out.println("Are you sure you want to transfer $" + transAmount + " to Account Number " + receiverID + "? (Y/N)");
				String choice = transferInput.next();
				if (choice.equals("Y")) {				
					String statement = "insert into pending_transfer (sender_id, receiver_id, amount, time_stamp)"
							+ "values(" + account.getAcctID() +","+ receiverID +","+ transAmount +", '"+ new Timestamp(new Date().getTime()) +"')";
					DBUtil.getInstance().postData(statement);
					System.out.println("Transfer process has started. Awaiting Receiver's approval.");
				} else if (choice.equals("N") ) {
					System.out.println("Transfer process is canceled.");
				} else {
					System.out.println("Invalid command. Transfer process is canceled.");
				}
			} else {
				System.out.println("Invalid transfer amount. Transfer process is canceled.");
			}
		}
		catch (Exception e) {
			logger.warn("Unable to get database connection",e);
			System.out.println("Error: " + e);
		}
		navigateAccount(customer, account);
	}

	private void viewPendingTransfer(Customer customer, BankingAcct account) {
		System.out.println("::::::::::::::::::::::::::::::::::::");
		System.out.println("Pending Transfers:");
		String statement = "select pt.ptrans_id, "
				+ "pt.amount, "
				+ "pt.time_stamp, "
				+ "sa.acct_id, "
				+ "sc.cust_id, "
				+ "sc.lname, "
				+ "sc.fname, "
				+ "ra.acct_id, "
				+ "rc.cust_id, "
				+ "rc.lname, "
				+ "rc.fname "
				+ "from pending_transfer pt "
				+ "join banking_account sa on sa.acct_id  = pt.sender_id "
				+ "join customer sc on sc.cust_id = sa.cust_id "
				+ "join banking_account ra on ra.acct_id  = pt.receiver_id "
				+ "join customer rc on rc.cust_id = ra.cust_id  "
				+ "where ra.acct_id = " + account.getAcctID();
		List<PendingTransfer> pendingTrans = new ArrayList<PendingTransfer>();
		try {
			ResultSet transferList = DBUtil.getInstance().getData(statement);
			while (transferList.next()) {
				pendingTrans.add(new PendingTransfer(transferList));
			};
			

			System.out.println("Name (Account ID) | Transfer ID | Amount | Date");
			
			for (PendingTransfer t : pendingTrans) {
				System.out.println(t.getSenderLastName() + ", " + t.getSenderFirstName() + " (" + t.getSenderAcctID() + ") | "
						+ t.getpTransID() + " | $"  + t.getAmount() + " | " + t.getTimeStamp());
			}
			
			System.out.println("::::::::::::::::::::::::::::::::::::");
			System.out.println("Please enter the Command (ACCEPT / REJECT) and Transfer ID:");
			System.out.println("i.e.: ACCEPT 123");
			System.out.println("Type EXIT to exit.");
			
			approvalAction(customer, account, pendingTrans);
		}
		catch (Exception e) {
			logger.warn("Unable to get database connection",e);
			System.out.println("Error: " + e);
		}
	}
	
	public void approvalAction(Customer customer, BankingAcct account, List<PendingTransfer> pendingTrans) {
		@SuppressWarnings("resource")
		Scanner approvalInput = new Scanner(System.in);
		System.out.println("Enter Action:");
		String choice[] = approvalInput.nextLine().split(" ");
		
		try {
			if (choice[0].equals("EXIT")) {
				navigateAccount(customer, account);
			} else if (choice.length == 2 && (choice[0].equals("ACCEPT") || choice[0].equals("REJECT"))) {
				int transcID = Integer.parseInt(choice[1]);
				
				List<PendingTransfer> filteredList = pendingTrans.stream()
						.filter(t -> t.getpTransID() == transcID)
						.collect(Collectors .toList());
				
				if (filteredList.isEmpty()) {
					System.out.println("Invalid Transaction number, please try again!");
					viewPendingTransfer(customer, account);
				} else if (choice[0].equals("ACCEPT")) {
					PendingTransfer transaction = filteredList.get(0);
					String statement = "update banking_account set balance = balance + amount from pending_transfer where receiver_id = acct_id and ptrans_id = " + choice[1] + "; "
							+ "update banking_account set balance = balance - amount from pending_transfer where sender_id = acct_id and ptrans_id = " + choice[1] + "; "
							+ "insert into transaction (acct_id, amount, trans_type, time_stamp) values(" + transaction.getReceiverAcctID() + ", "
							+ transaction.getAmount() + ", 'receive','"+ new Timestamp(new Date().getTime())+"'); "
							+ "insert into transaction (acct_id, amount, trans_type, time_stamp) values(" + transaction.getSenderAcctID() + ", "
							+ transaction.getAmount() + ", 'transfer','"+ new Timestamp(new Date().getTime())+"'); "
							+ "delete from pending_transfer where ptrans_id = " + transcID;
					DBUtil.getInstance().postData(statement);
					account.setBalance( account.getBalance() + transaction.getAmount() );
					System.out.println("The transfer has been accepted.  Your account's new balance is: " + account.getBalance());					
				} else {
					String statement = "delete from pending_transfer where ptrans_id = " + transcID;
					DBUtil.getInstance().postData(statement);
					System.out.println("The transfer has been rejected.");		
				}
//				
			} else {
				System.out.println("Incorrect command.");
			}
		}
		catch (Exception e) {
			logger.warn("Unable to get database connection",e);
			System.out.println("Error: " + e);
		}
		viewPendingTransfer(customer, account);
	}
}














