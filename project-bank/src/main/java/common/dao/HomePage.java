package common.dao;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import common.util.DBUtil;

public class HomePage {
    private static final Logger logger = LogManager.getLogger(DBUtil.class);
	private void homeMenu() {
		System.out.println("::::::::::::::::::::::::::::::::::::");
		System.out.println("Welcome to ExPublic Bank");
		System.out.println("::::::::::::::::::::::::::::::::::::");
		System.out.println("1. Customer Login");
		System.out.println("2. Customer Create Account");
		System.out.println("3. Admin Login");
		System.out.println("4. Exit");
	}
	
	public void navigateHome() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		LoginPage login = new LoginPage();
		
		homeMenu();
		
		System.out.println("Enter Action: ");
		String choice = input.nextLine();
		
		switch(choice) {
		case "1":
			//go to login screen with 1 for customer
			login.navigateLogin(true);
			break;
		case "2":
			//go to customer create screen
			createCustomer();
			break;
		case "3":
			//go to login screen with 0 for admin
			
			login.navigateLogin(false);
			break;
		case "4":
			//exit program
			break;
		}
	}
	
	private void createCustomer() {
		@SuppressWarnings("resource")
		Scanner creationInput = new Scanner(System.in);
		
		System.out.println("1. Register as client");
		System.out.println("Enter First Name: ");
		String fName = creationInput.nextLine();
		System.out.println("Enter Last Name: ");
		String lName = creationInput.nextLine();
		System.out.println("Enter Username: ");
		String username = creationInput.nextLine();
		System.out.println("Enter Password: ");
		String password = (creationInput.nextLine());
				
		try {
			String statement = "insert into customer (fname, lname, username, password) "
					+ "values('" + fName + "', '" + lName + "', '" + username + "', '" + password + "')";
			DBUtil.getInstance().postData(statement);
			System.out.println("Account as been created.  Please try to log in.");
		}
		catch (Exception e) {
			System.out.println("Error: unable to save: "+e.getMessage());
			logger.error(e);
		}
		navigateHome();
	}
}
