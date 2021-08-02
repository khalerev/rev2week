package common.pojo;

import java.sql.ResultSet;

public class Customer {
	private int custID;
	private String lName;
	private String fName;
	private String username;
	
	public Customer() {
		
	}
	
	public Customer(int custID, String lName, String fName, String username) {
		this.custID = custID;
		this.lName = lName;
		this.fName = fName;
		this.username = username;
	}
	
	public Customer(ResultSet c) throws Exception{
		this.custID = c.getInt(1);
		this.fName = c.getString(2);
		this.lName = c.getString(3);
		this.username = c.getString(4);
	}
	
	public int getCustID() {
		return custID;
	}
	public void setCustID(int custID) {
		this.custID = custID;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
