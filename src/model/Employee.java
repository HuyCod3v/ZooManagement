package model;

import java.io.Serializable;

public class Employee implements Serializable {
	private String employeeId;
	private String employeeName;
	private int gender;
	private String birthday;
	private String phone;
	private String address;
	public Employee(){
		
	}
	public Employee(String employeeId, String employeeName, int gender, String birthday, String phone, String address) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.gender = gender;
		this.birthday = birthday;
		this.phone = phone;
		this.address = address;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
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
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", gender=" + gender
				+ ", birthday=" + birthday + ", phone=" + phone + ", address=" + address + "]";
	}
	
	
}
