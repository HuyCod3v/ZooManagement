package model;

import java.io.Serializable;

public class UserType implements Serializable {
	private int userTypeId;
	private String userTypeName;
	
	public UserType(int userTypeId, String userTypeName) {
		this.userTypeId = userTypeId;
		this.userTypeName = userTypeName;
	}
	public int getUserTypeId() {
		return userTypeId;
	}
	public void setUserTypeId(int userTypeId) {
		this.userTypeId = userTypeId;
	}
	public String getUserTypeName() {
		return userTypeName;
	}
	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}
	
}
