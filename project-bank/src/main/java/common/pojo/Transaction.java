package common.pojo;

import java.sql.ResultSet;
import java.sql.Timestamp;

public class Transaction {
	private int transID;
	private int acctID;
	private int custID;
	private String lName;
	private String fName;
	private double amount;
	private String transType;
	private Timestamp timeStamp;
	
	public Transaction (int transID, int acctID, int custID, String lName, String fName, double amount, String transType, Timestamp timeStamp) {
		this.transID = transID;
		this.acctID = acctID;
		this.custID = custID;
		this.lName = lName;
		this.fName = fName;
		this.amount = amount;
		this.timeStamp = timeStamp;
	}
	
	public Transaction (ResultSet t) throws Exception{
		this.transID = t.getInt(1);
		this.acctID = t.getInt(2);
		this.custID = t.getInt(3);
		this.lName = t.getString(4);
		this.fName = t.getString(5);
		this.amount = t.getDouble(6);
		this.transType = t.getString(7);
		this.timeStamp = t.getTimestamp(8);
	}
	
	public int getTransID() {
		return transID;
	}
	public void setTransID(int transID) {
		this.transID = transID;
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
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getTransType() {
		return transType;
	}
	public void setTransType(String transType) {
		this.transType = transType;
	}
	public Timestamp getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}
}