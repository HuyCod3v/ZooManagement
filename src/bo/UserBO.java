package bo;

import java.util.ArrayList;

import dao.UserDAO;
import model.User;

public class UserBO {
	public ArrayList<User> listAllUser(){
		return (ArrayList<User>) new UserDAO().listAllUser();
	}
	
	public ArrayList<User> listAllUserNoAccount(){
		return (ArrayList<User>) new UserDAO().listAllUserNoAccount();
	}
	
	public User getUserByUserName(String username){
		return  new UserDAO().getUserByUserName(username);
	}
	
	public boolean createUser(User user){
		return  new UserDAO().createUser(user);
	}
	
	public boolean deleteUser(String username){
		return  new UserDAO().deleteUser(username);
	}
	
	public User findUser(String username, String password){
		return  new UserDAO().find(username, password);
	}
	
}
