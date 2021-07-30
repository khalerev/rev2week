package common.pojo;

public class Client {
	private int id;
	private String lastName;
	private String firstName;
	private String gender;
	private String address;
	private String username;
	private String password;
	
	public Client() {
		super();
	}
	
	public Client(int id, String lastName, String firstName, String gender, String address, String username, String password) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.gender = gender;
		this.address = address;
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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
