package common.pojo;

import java.sql.ResultSet;

public class BankingAcct {
	private int acctID;
	private int custID;
	private String fName;
	private String lName;
	private double balance;
	private boolean isApprove;
	
	public BankingAcct(int acctID, int custID, String fName, String lName, double balance, boolean isApprove) {
		this.acctID = acctID;
		this.custID = custID;
		this.fName = fName;
		this.lName = lName;
		this.balance = balance;
		this.isApprove = isApprove;
	}
	
	public BankingAcct(ResultSet acct) throws Exception {
		this.acctID = acct.getInt(1);
		this.custID = acct.getInt(2);
		this.balance = acct.getDouble(3);
		this.isApprove = acct.getBoolean(4);
		this.fName = acct.getString(6);
		this.lName = acct.getString(7);
	}
	
	public int getAcctID() {
		return acctID;
	}
	public void setAcctID(int acctID) {
		this.acctID = acctID;
	}
	public int getCustID() {
		return custID;
	}
	public void setFName(String fName) {
		this.fName = fName;
	}
	public String getFName() {
		return fName;
	}
	public void setLName(String lName) {
		this.lName = lName;
	}
	public String getLName() {
		return lName;
	}
	public void setCustID(int custID) {
		this.custID = custID;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public boolean isApprove() {
		return isApprove;
	}
	public void setApprove(boolean isApprove) {
		this.isApprove = isApprove;
	}
	
	
}
