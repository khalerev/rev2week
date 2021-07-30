package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import common.pojo.Client;
import common.pojo.ClientAccount;
import common.util.*;

public class ClientDAO {
	
	private static final Logger logger = LogManager.getLogger(ClientDAO.class);
	
	public Client saveClient(Client c) {
		try {
			Connection conn = DBUtil.getInstance().getConnection();
			
			PreparedStatement pstmt = 
					conn.prepareStatement(
							"insert into public.client "
							+ "(last_name, first_name, gender, address, username, password) "
							+ "values (?,?,?,?,?,?)"
						);
			
			pstmt.setString(1, c.getLastName());
			pstmt.setString(2, c.getFirstName());
			pstmt.setString(3, c.getGender());
			pstmt.setString(4, c.getAddress());
			pstmt.setString(5, c.getUsername());
			pstmt.setString(6, c.getPassword());
			
			pstmt.executeUpdate();
		}
		catch (Exception e) {
			System.out.println("Error: unable to save: "+e.getMessage());
			logger.error(e);
		}
		
		
		return c;
		//does not check for duplicates or update existing record
	}
	
	public Client createClient(Scanner input) {
		Client c = new Client();
		
		System.out.println("1. Register as client");
		System.out.println("Enter First Name: ");
		c.setFirstName(input.nextLine());
		System.out.println("Enter Last Name: ");
		c.setLastName(input.nextLine());
		System.out.println("Gender: (M/F)");
		c.setGender(input.nextLine());
		System.out.println("Enter Address: ");
		c.setAddress(input.nextLine());
		System.out.println("Enter Username: ");
		c.setUsername(input.nextLine());
		System.out.println("Enter Password: ");
		c.setPassword(input.nextLine());
		
		return saveClient(c);
	}
	
	public Client loginClient(Scanner input) {
		Client c = new Client();
		
		try {
			Connection conn = DBUtil.getInstance().getConnection();
			
			PreparedStatement pstmt = 
					conn.prepareStatement(
							"select * from public.client "
							+ "where username = ? "
							+ "and password = ?"
					);
			
			System.out.println("Enter Username: ");
			pstmt.setString(1, input.nextLine());
			System.out.println("Enter Password: ");
			pstmt.setString(2, input.nextLine());
			
			ResultSet rs = pstmt.executeQuery();;
			
			if (rs.next()) {
				c = new Client(
						rs.getInt(1),		//id
						rs.getString(2),	//lastname
						rs.getString(3),	//firstname
						rs.getString(4),	//gender
						rs.getString(5),	//address
						rs.getString(6),	//username
						null				//password
				);
			} else {
				//login fail
				System.out.println("Login failed, try again.");
				this.loginClient(input);
			}
		}
			catch (Exception e) {
			logger.error(e);
		}
		
		return c;
		
	}
	
	public ClientAccount createAccount(Scanner input, int clientID) {
		ClientAccount ca = new ClientAccount();
		
		System.out.println("Creating Checking or Savings Account? (C/S)");
		ca.setAcctType(input.nextLine());
		System.out.println("Amount to Deposit: (Minimum of $ " + AppConstants.minimumStart + " )");
		double deposit = input.nextDouble();
		if (deposit >= 1000) {
			ca.setBalance(deposit);
		} else {
			System.out.println("Minimum required to make new account is $ " + AppConstants.minimumStart + " )");
			this.createAccount(input, clientID);
			}
		
		return saveClientAccount(ca, clientID);
	}
	
	public ClientAccount saveClientAccount(ClientAccount ca, int clientID) {
		try {
			Connection conn = DBUtil.getInstance().getConnection();
			
			PreparedStatement pstmt = 
					conn.prepareStatement(
							"insert into public.client_acct "
							+ "(client_id, acct_type, balance) "
							+ "values (?,?,?)"
					);
			
			pstmt.setInt (1, clientID);
			pstmt.setString (2, ca.getAcctType());
			pstmt.setDouble(3, ca.getBalance());
			
			pstmt.executeUpdate();
			
			System.out.println("Successful creation.");
		}
		catch (Exception e) {
			System.out.println("Error: unable to save: "+e.getMessage());
			logger.error(e);
		}
		
		return ca;
	}
	
	public List<ClientAccount> getUserAccounts(int clientID) {
		List<ClientAccount> clientAccounts = new ArrayList<ClientAccount>();
		
		try {
			Connection userAccountConnection = DBUtil.getInstance().getConnection();
			
			PreparedStatement userAccountStatement = userAccountConnection.prepareStatement(
						"select * from public.client_acct "
						+ "where client_id = ?"
					);
			
			userAccountStatement.setInt(1, clientID);
			
			ResultSet userAccounts = userAccountStatement.executeQuery();
			
			while (userAccounts.next()) {
				clientAccounts.add(
						new ClientAccount(
								userAccounts.getInt(1),		//client_id
								userAccounts.getString(2),	//acct_type
								userAccounts.getInt(3),		//acct_id
								userAccounts.getDouble(4)		//balance
						));
			}
			
		} catch (Exception e) {
			System.out.println("Error: unable to save: "+e.getMessage());
			logger.error(e);
		}
		
		return clientAccounts;
	}
	
	//TODO: update client account after deposit
	public ClientAccount depositClientAccount(Scanner input, int clientID) {
		ClientAccount ca = new ClientAccount();
		
		System.out.println("How much would you like to deposit?");
		ca.setBalance(ca.getBalance()+input.nextDouble());
		
		return saveClientAccount(ca, clientID);
	}
	
	public ClientAccount withdrawClientAccount(Scanner input, int clientID) {
		ClientAccount ca = new ClientAccount();
		
		System.out.println("How much would you like to withdraw?");
		double desiredWithdraw = input.nextDouble();
		if (ca.getBalance() > desiredWithdraw) {
			ca.setBalance(ca.getBalance() - desiredWithdraw);
			System.out.println("Successfully withdraw " + desiredWithdraw);
		} else {
			System.out.println("Insufficient funds");
		}
		
		return saveClientAccount(ca, clientID);
	}
}
	
















