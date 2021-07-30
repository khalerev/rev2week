package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import common.pojo.Admin;
import common.pojo.Client;
import common.pojo.ClientAccount;
import common.util.*;

public class AdminDAO {
	private static final Logger logger = LogManager.getLogger(AdminDAO.class);
	
	public Admin loginAdmin(Scanner input) {
		Admin a = new Admin();
		
		try {
			Connection conn = DBUtil.getInstance().getConnection();
			
			PreparedStatement pstmt = 
					conn.prepareStatement(
							"select * from public.admin "
							+ "where username = ? "
							+ "and password = ?"
					);
			
			System.out.println("Enter Username: ");
			pstmt.setString(1, input.nextLine());
			System.out.println("Enter Password: ");
			pstmt.setString(2, input.nextLine());
			
			ResultSet rs = pstmt.executeQuery();;
			
			if (rs.next()) {
				a = new Admin(
						rs.getInt(1),		//id
						rs.getString(2),	//lastname
						rs.getString(3),	//firstname
						rs.getString(4),	//address
						rs.getString(5),	//username
						null				//password
				);
			} else {
				//login fail
				System.out.println("Login failed, try again.");
				this.loginAdmin(input);
			}
		}
			catch (Exception e) {
			logger.error(e);
		}
		
		return a;
		
	}
}
