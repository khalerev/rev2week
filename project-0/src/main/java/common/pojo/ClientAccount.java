package common.pojo;

public class ClientAccount {
	private int clientID;
	private int acctID;
	private String acctType;
	private double balance;
	
	public ClientAccount() {
		super();
	}
	
	public ClientAccount(int clientID, String acctType, int acctID, double balance) {
		super();
		this.clientID = clientID;
		this.acctType = acctType;
		this.acctID = acctID;
		this.balance = balance;
	}
	
	public int getClientID() {
		return clientID;
	}
	public void setClientID(int clientID) {
		this.clientID = clientID;
	}
	public String getAcctType() {
		return acctType;
	}
	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}
	public int getAcctID() {
		return acctID;
	}
	public void setAcctID(int acctID) {
		this.acctID = acctID;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
}
