package common.pojo;

public class Admin {
	private int adminID;
	private String lastName;
	private String firstName;
	private String address;
	private String username;
	private String password;
	
	public Admin() {
		super();
	}
	
	public Admin(int adminID, String lastName, String firstName, String address, String username, String password) {
		super();
		this.adminID = adminID;
		this.lastName = lastName;
		this.firstName = firstName;
		this.address = address;
		this.username = username;
		this.password = password;
	}

	public int getAdminID() {
		return adminID;
	}

	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
