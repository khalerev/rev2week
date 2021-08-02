package common.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import common.pojo.Transaction;
import common.util.DBUtil;

public class TransactionPage {
    private static final Logger logger = LogManager.getLogger(DBUtil.class);
	public void viewTransaction() {
		System.out.println("::::::::::::::::::::::::::::::::::::");
		System.out.println("Customers' Transactions Log:");
		
		String statement = "select t.trans_id, "
				+ "b.acct_id, "
				+ "c.cust_id, "
				+ "c.lname, "
				+ "c.fname, "
				+ "t.amount, "
				+ "t.trans_type, "
				+ "t.time_stamp "
				+ "from transaction t "
				+ "join banking_account b on b.acct_id = t.acct_id "
				+ "join customer c on c.cust_id = b.cust_id "
				+ "order by t.time_stamp desc";
		List<Transaction> transactionList = new ArrayList<Transaction>();
		
		try {
			ResultSet transactions = DBUtil.getInstance().getData(statement);
			
			while (transactions.next()) {
				transactionList.add(new Transaction(transactions));
			};
				
		} catch(Exception e) {
			logger.warn("Unable to get database connection",e);
			System.out.println("Error: " + e);
		}
		
		filterList(transactionList, "ALL");
	}
	
	private void filterList(List<Transaction> transactionList, String filter) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("List Filtered By " + filter);
		System.out.println("Last Name | First Name | Account ID | Transaction Type | Amount | Date");
		List<Transaction> filteredList = transactionList;
		
		if(filter.equals("EXIT")) {
			new AdminPage().navigateAdmin();
		} else if(filter.equals("ALL") ) {
			filteredList = transactionList;
		} else {
			filteredList = transactionList.stream()
					.filter(t -> t.getAcctID() == Integer.parseInt(filter))
					.collect(Collectors.toList());
		}
		
		for (Transaction t : filteredList) {
			System.out.println(t.getlName() + " | " + t.getfName() + " | " + t.getAcctID() + " | $" + t.getAmount() + " | " + t.getTransType() + " | " + t.getTimeStamp());
		}
		
		System.out.println("::::::::::::::::::::::::::::::::::::");
		System.out.println("Enter Account ID to Filter by ID (ALL to get all):");
		System.out.println("Type EXIT to exit.");
		String newFilter = input.nextLine();
		
		filterList(transactionList, newFilter);
	}
}
