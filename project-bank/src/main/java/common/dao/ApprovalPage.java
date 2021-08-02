package common.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import common.pojo.BankingAcct;
import common.util.DBUtil;

public class ApprovalPage {
    private static final Logger logger = LogManager.getLogger(DBUtil.class);
    
	public void viewApproval() {
		System.out.println("::::::::::::::::::::::::::::::::::::");
		System.out.println("Pending Approval List");
		String statement = "select * from banking_account b "
				+ "join customer c on c.cust_id = b.cust_id "
				+ "where b.is_approve = FALSE";
		List<BankingAcct> approvalList = new ArrayList<BankingAcct>();
		
		try {
			ResultSet pendingApproval = DBUtil.getInstance().getData(statement);
			
			while (pendingApproval.next()) {
				approvalList.add(new BankingAcct(pendingApproval));
			}
				
		} catch(Exception e) {
			logger.warn("Unable to get database connection",e);
			System.out.println("Error: " + e);
		}
		
		System.out.println("Last Name | First Name | Account ID | Balance");
		for (BankingAcct a : approvalList) {
			System.out.println(a.getLName() + " | " + a.getFName() + " | " + a.getAcctID() + " | $" + a.getBalance());
		}

		System.out.println("::::::::::::::::::::::::::::::::::::");
		System.out.println("Please enter the Command (APPROVE / DENY) and Account ID:");
		System.out.println("i.e.: APPROVE 123");
		System.out.println("Type EXIT to exit.");
		
		approvalAction();
	}
	
	public void approvalAction () {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Action:");
		String choice[] = input.nextLine().split(" ");
		
		try {
			if (choice[0].equals("EXIT")) {
				new AdminPage().navigateAdmin();
			} else if (choice.length == 2 && (choice[0].equals("APPROVE") || choice[0].equals("DENY"))) {
				if (choice[0].equals("APPROVE")) {
					String statement = "update banking_account set is_approve = true where acct_id = " + choice[1];
					DBUtil.getInstance().postData(statement);
					System.out.println("User Account " + choice[1] + " has been approved.");					
				} else {
					String statement = "delete from banking_account where acct_id  = " + choice[1];
					DBUtil.getInstance().postData(statement);
					System.out.println("User Account " + choice[1] + " has been denied.");
				}
				
			} else {
				System.out.println("Incorrect command.");
			}
		}
		catch (Exception e) {
			logger.warn("Unable to get database connection",e);
			System.out.println("Error: " + e);
		}
		approvalAction();
	}
}
