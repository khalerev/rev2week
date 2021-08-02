package common.pojo;

import java.sql.ResultSet;
import java.sql.Timestamp;

public class PendingTransfer {
	private int pTransID;
	private double amount;
	private Timestamp timeStamp;
	private int senderAcctID;
	private int senderCustID;
	private String senderLastName;
	private String senderFirstName;
	private int receiverAcctID;
	private int receiverCustID;
	private String receiverLastName;
	private String receiverFirstName;
	
	public PendingTransfer(int pTransID, Double amount, Timestamp timeStamp,
			int senderAcctID, int senderCustID, String senderLastName,
			String senderFirstName, int receiverAcctID, int receiverCustID,
			String receiverLastName, String receiverFirstName) {
		this.pTransID = pTransID;
		this.amount = amount;
		this.timeStamp = timeStamp;
		this.senderAcctID = senderAcctID;
		this.senderCustID = senderCustID;
		this.senderLastName = senderLastName;
		this.senderFirstName = senderFirstName;
		this.receiverAcctID = receiverAcctID;
		this.receiverCustID = receiverCustID;
		this.receiverLastName = receiverLastName;
		this.receiverFirstName = receiverFirstName;
	}
	
	public PendingTransfer(ResultSet p) throws Exception {
		this.pTransID = p.getInt(1);
		this.amount = p.getDouble(2);
		this.timeStamp = p.getTimestamp(3);
		this.senderAcctID = p.getInt(4);
		this.senderCustID = p.getInt(5);
		this.senderLastName = p.getString(6);
		this.senderFirstName = p.getString(7);
		this.receiverAcctID = p.getInt(8);
		this.receiverCustID = p.getInt(9);
		this.receiverLastName = p.getString(10);
		this.receiverFirstName = p.getString(11);
	}
	
	
	public int getpTransID() {
		return pTransID;
	}
	public void setpTransID(int pTransID) {
		this.pTransID = pTransID;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Timestamp getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}
	public int getSenderAcctID() {
		return senderAcctID;
	}
	public void setSenderAcctID(int senderAcctID) {
		this.senderAcctID = senderAcctID;
	}
	public int getSenderCustID() {
		return senderCustID;
	}
	public void setSenderCustID(int senderCustID) {
		this.senderCustID = senderCustID;
	}
	public String getSenderLastName() {
		return senderLastName;
	}
	public void setSenderLastName(String senderLastName) {
		this.senderLastName = senderLastName;
	}
	public String getSenderFirstName() {
		return senderFirstName;
	}
	public void setSenderFirstName(String senderFirstName) {
		this.senderFirstName = senderFirstName;
	}
	public int getReceiverAcctID() {
		return receiverAcctID;
	}
	public void setReceiverAcctID(int receiverAcctID) {
		this.receiverAcctID = receiverAcctID;
	}
	public int getReceiverCustID() {
		return receiverCustID;
	}
	public void setReceiverCustID(int receiverCustID) {
		this.receiverCustID = receiverCustID;
	}
	public String getReceiverLastName() {
		return receiverLastName;
	}
	public void setReceiverLastName(String receiverLastName) {
		this.receiverLastName = receiverLastName;
	}
	public String getReceiverFirstName() {
		return receiverFirstName;
	}
	public void setReceiverFirstName(String receiverFirstName) {
		this.receiverFirstName = receiverFirstName;
	}
}
