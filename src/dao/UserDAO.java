package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import lib.ConnectDbLib;
import model.User;

public class UserDAO {
	Connection con;
	ConnectDbLib ConLib = new ConnectDbLib();
	PreparedStatement pst;
	ResultSet rs;
	
	public User checkUserLogin(String username,String password){
		User user=null;
		try{
			con = ConLib.getConnectMySQL();
			String sql = "SELECT * FROM user as u join user_type as ut ON u.UserTypeID = ut.UserTypeID join employee as e ON u.Username LIKE e.Username WHERE u.Username LIKE ? AND u.Password LIKE ? LIMIT 1";
			pst = con.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, password);
			rs = pst.executeQuery();
			if(rs.next()){
				user = new User(rs.getString("Username"), rs.getString("Password"), rs.getInt("UserTypeID"), rs.getString("UserTypeName"), rs.getString("EmployeeID"), rs.getString("EmployeeName"), rs.getInt("Gender"),rs.getString("Birthday"), rs.getString("Phone"), rs.getString("Address"));
			}
		}catch(Exception e){
			System.out.println("Lỗi cmnr");
		}finally {
			try{
				con.close();
				pst.close();
				ConLib.closeConnect();
			}catch(Exception e){
				
			}
		}
		
		return user;
	}
	
	public void upadateUser(User user,String id){
		con = ConLib.getConnectMySQL();
		String sql = "UPDATE employee SET EmployeeName = ?, Gender=? , Birthday= ?, Phone=?, Address=? WHERE EmployeeID LIKE ?";
		try{
			pst = con.prepareStatement(sql);
			pst.setString(1, user.getEmployeeName());
			pst.setInt(2, user.getGender());
			pst.setString(3, user.getBirthday());
			pst.setString(4, user.getPhone());
			pst.setString(5, user.getAddress());
			pst.setString(6, id);
			pst.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try{
				con.close();
				pst.close();
				ConLib.closeConnect();
			}catch(Exception e){
				
			}
		}
	}
	public void upadatePassword(User user){
		con = ConLib.getConnectMySQL();
		String sql = "UPDATE user SET Password = ? WHERE Username LIKE ?";
		try{
			pst = con.prepareStatement(sql);
			pst.setString(1, user.getPassword());
			pst.setString(2, user.getUsername());
			pst.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try{
				con.close();
				pst.close();
				ConLib.closeConnect();
			}catch(Exception e){
				
			}
		}
	}
	
	public User getEmployeeByID(String id){
		User user = null;
		con = ConLib.getConnectMySQL();
		String sql = "SELECT * FROM employee WHERE EmployeeID LIKE ? LIMIT 1";
		try{
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			rs =pst.executeQuery();
			if(rs.next()){
				user = new User("", "", 0, "", rs.getString("EmployeeID"), rs.getString("EmployeeName"), rs.getInt("Gender"), rs.getString("Birthday"), rs.getString("Phone"), rs.getString("Address"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try{
				con.close();
				pst.close();
				ConLib.closeConnect();
			}catch(Exception e){
				
			}
		}
		return user;
	}
	
}
