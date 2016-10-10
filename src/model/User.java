package model;

public class User {
	private String username;
	private String password;
	private int UserTypeID;
	private String UserTypeName;
	private String EmployeeID;
	private String EmployeeName;
	private int gender;
	private String birthday;
	private String phone;
	private String address;
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
	public int getUserTypeID() {
		return UserTypeID;
	}
	public void setUserTypeID(int userTypeID) {
		UserTypeID = userTypeID;
	}
	public String getUserTypeName() {
		return UserTypeName;
	}
	public void setUserTypeName(String userTypeName) {
		UserTypeName = userTypeName;
	}
	public String getEmployeeID() {
		return EmployeeID;
	}
	public void setEmployeeID(String employeeID) {
		EmployeeID = employeeID;
	}
	public String getEmployeeName() {
		return EmployeeName;
	}
	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public User(String username, String password, int userTypeID, String userTypeName, String employeeID,
			String employeeName, int gender, String birthday, String phone, String address) {
		super();
		this.username = username;
		this.password = password;
		UserTypeID = userTypeID;
		UserTypeName = userTypeName;
		EmployeeID = employeeID;
		EmployeeName = employeeName;
		this.gender = gender;
		this.birthday = birthday;
		this.phone = phone;
		this.address = address;
	}
	public User(String employeeName, int gender, String birthday, String phone, String address) {
		super();
		EmployeeName = employeeName;
		this.gender = gender;
		this.birthday = birthday;
		this.phone = phone;
		this.address = address;
	}
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
}
