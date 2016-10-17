package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.User;
import utilities.DatabaseConnection;

public class UserDAO extends AbstractDAO {
	
	
	public User find(String username, String password){
		User user=null;
		PreparedStatement pst = null;
        Connection con = null;
        ResultSet rs = null;
        
		try{
			con = DatabaseConnection.getConnection();
			String sql = "SELECT * FROM [User] u join UserType ut ON u.UserTypeID = ut.UserTypeID join Employee e ON u.EmployeeID = e.EmployeeID WHERE u.Username = ? AND u.Password = ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, password);
			rs = pst.executeQuery();
			if(rs.next()){
				user = new User(rs.getString("Username"), rs.getString("Password"), rs.getInt("UserTypeID"), rs.getString("UserTypeName"), rs.getString("EmployeeID"), rs.getString("EmployeeName"), rs.getInt("Gender"),rs.getString("Birthday"), rs.getString("Phone"), rs.getString("Address"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try{
				con.close();
				pst.close();
				rs.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return user;
	}
	
	public void edit(User user,String id){
		PreparedStatement pst = null;
        Connection con = null;
		String sql = "UPDATE employee SET EmployeeName = ?, Gender=? , Birthday= ?, Phone=?, Address=? WHERE EmployeeID LIKE ?";
		try{
			con = DatabaseConnection.getConnection();
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
				
			}catch(Exception e){
				
			}
		}
	}
	
	public void editPassword(User user){
		PreparedStatement pst = null;
        Connection con = null;
		con = DatabaseConnection.getConnection();
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
			}catch(Exception e){
				
			}
		}
	}
	
	public User findById(String id){
		User user = null;
		PreparedStatement pst = null;
        Connection con = null;
        ResultSet rs = null;
		con = DatabaseConnection.getConnection();
		String sql = "SELECT * FROM [Employee] WHERE EmployeeID = ?";
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
				rs.close();
			}catch(Exception e){
				
			}
		}
		return user;
	}
	
}
