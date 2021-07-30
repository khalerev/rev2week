package prompt;

//ConsoleApp.java

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import common.pojo.Admin;
import common.pojo.Client;
import common.pojo.ClientAccount;
import dao.ClientDAO;
import dao.AdminDAO;
//import service.ProductService;

public class Prompt {
	
	private static final Logger logger = LogManager.getLogger(Prompt.class);
	
	private ClientDAO clientdao = new ClientDAO();
	private AdminDAO admindao = new AdminDAO();
	
	public void start() {
		
		Scanner input = new Scanner(System.in);
		
		startMenu();
		
		System.out.println("Enter Action: ");
		String choice = input.nextLine();
		
		switch(choice) {
			case "1":
				clientdao.createClient(input);
				System.out.println("Successfully registered");
				System.out.println(":::::::::::::::::::::::::::::::::::::");
				start();
				break;
			case "2":
				Client c = clientdao.loginClient(input);
				System.out.println("Welcome " + c.getFirstName());
				System.out.println("::::::::::::::::::::::::::::::::::::::");
				repeatClientLoginMenu(choice, input, c);
				break;
			case "3": //login as admin
				Admin a = admindao.loginAdmin(input);
				System.out.println("Welcome " + a.getFirstName());
				System.out.println("::::::::::::::::::::::::::::::::::::::");
				repeatAdminLoginMenu(choice, input, a);
				break;
			case "4": //exiting program
			break;
		
				
		}
		
		input.close();
		
		System.out.println("Exited.");
	}
	
	private void startMenu() {
		System.out.println("Expublic Bank");
		System.out.println("1. Register");
		System.out.println("2. Login as client");
		System.out.println("3. Login as admin");
		System.out.println("4. Quit");
	}
	
	private void clientLoginMenu() {
		System.out.println("1. Make a new account");
		System.out.println("2. View");
		System.out.println("3. Deposit");
		System.out.println("4. Withdraw");
		System.out.println("5. Transfer");
		System.out.println("6. Logout");
	}
	
	private void repeatClientLoginMenu(String choice, Scanner input, Client c) {
		clientLoginMenu();
		choice = input.nextLine();
		
		switch(choice) {
		case "1":
			clientdao.createAccount(input, c.getId());
			break;
		case "2":
			//view
			List<ClientAccount> accounts = clientdao.getUserAccounts(c.getId());
			printUserAccounts(accounts);
			this.repeatClientLoginMenu(choice, input, c);
			break;
		case "3":
			//deposit
			clientdao.depositClientAccount(input, c.getId());
			break;
		case "4":
			//withdraw
			clientdao.withdrawClientAccount(input, c.getId());
			break;
		case "5":
			//transfer
			break;
		case "6":
			//logout
			start();
			break;
		}

		choice = input.nextLine();
		this.repeatClientLoginMenu(choice, input, c);
	}
	
	private void adminLoginMenu() {
		System.out.println("1. Pending Accounts");
		System.out.println("2. View Customer Bank Accounts");
		System.out.println("3. Logout");
	}
	
	private void repeatAdminLoginMenu(String choice, Scanner input, Admin a) {
		adminLoginMenu();
		choice = input.nextLine();
		
		switch(choice) {
		case "1":
			System.out.println("this is for viewing pending accounts");
			break;
		case "2":
			System.out.println("this is for viewing bank accounts");
			break;
		case "3":
			start();
			break;
		}
		
		System.out.println("repeating admin login menu.........");
	}
	
	private void printUserAccounts(List<ClientAccount> accounts) {
		System.out.println("Account ID | Account Type | Balance");
		for (ClientAccount ca : accounts) {
			System.out.println(ca.getAcctID() + " | " + ca.getAcctType() + " | " + ca.getBalance());
		}
	}
}













