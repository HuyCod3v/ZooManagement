package bo;

import java.util.ArrayList;

import dao.UserTypeDAO;
import model.UserType;

public class UserTypeBO {
	public ArrayList<UserType> getAllUserType(){
		return new UserTypeDAO().getAllUserType();
	}
}
