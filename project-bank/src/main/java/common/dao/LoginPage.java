package common.dao;

import java.sql.ResultSet;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import common.pojo.Customer;
import common.util.DBUtil;

public class LoginPage {
    private static final Logger logger = LogManager.getLogger(DBUtil.class);
    
	public void navigateLogin(Boolean isCustomer) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("::::::::::::::::::::::::::::::::::::");
		System.out.println("Please Log In");
		System.out.println("Username: ");
		String username = input.nextLine();
		System.out.println("Password: ");
		String password = input.nextLine();
		
		userLoginCheck(username, password, isCustomer);
	}
	
	private void userLoginCheck(String username, String password, Boolean isCustomer) {
		String tableName;
		
		if (isCustomer) {
			//call db to check customer table
			tableName = "public.customer";
		} else {
			//call db to check admin table
			tableName = "public.admin";
		}

		String statement = "select * from " + tableName
				+ " where username = '" + username + "'" 
				+ " and password = '" + password + "'";

		try {
			ResultSet loginResult = DBUtil.getInstance().getData(statement);
			
			if (loginResult.next()) {
				if (isCustomer) {
					//navigate to customer screen
					Customer c = new Customer(loginResult);
					new CustomerPage().navigateCustomer(c);
				} else {
					//navigate to admin screen
					new AdminPage().navigateAdmin();
				}
			} else {
				System.out.println("Login Failed. Please try again.");
				navigateLogin(isCustomer);
			}	
		} catch(Exception e ) {
			logger.warn("Unable to get database connection",e);
			System.out.println("Error: " + e);
		}
		
	}
}
