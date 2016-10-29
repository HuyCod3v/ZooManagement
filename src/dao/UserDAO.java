package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Employee;
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
			String sql = "SELECT * FROM employee left join user ON employee.EmployeeID = user.EmployeeID "
					+ "left join usertype ON user.UserTypeID = usertype.UserTypeID where user.Username = ? AND Password = ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, password);
			rs = pst.executeQuery();
			if(rs.next()){
				user = new User();
				user.setEmployeeID(rs.getString(1));
				user.setEmployeeName(rs.getString(2));
				user.setGender(rs.getInt(3));
				user.setBirthday(rs.getString(4));
				user.setPhone(rs.getString(5));
				user.setAddress(rs.getString(6));
				user.setUsername(rs.getString(7));
				user.setPassword(rs.getString(8));
				user.setUserTypeID(rs.getInt(9));
				user.setUserTypeName(rs.getString(12));
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
	
	public List<User> listAllUser(){
		List<User> list= new ArrayList<User>();
		PreparedStatement pst = null;
        Connection con = null;
        ResultSet rs = null;
		try{
			con = DatabaseConnection.getConnection();
			String sql = "SELECT * FROM employee inner join user ON employee.EmployeeID = user.EmployeeID "
					+ "inner join usertype ON user.UserTypeID = usertype.UserTypeID";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				User user = new User();
				user.setEmployeeID(rs.getString(1));
				user.setEmployeeName(rs.getString(2));
				user.setGender(rs.getInt(3));
				user.setBirthday(rs.getString(4));
				user.setPhone(rs.getString(5));
				user.setAddress(rs.getString(6));
				user.setUsername(rs.getString(7));
				user.setPassword(rs.getString(8));
				user.setUserTypeID(rs.getInt(9));
				user.setUserTypeName(rs.getString(12));
				list.add(user);
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
		return list;
	}
	
	public List<User> listAllUserNoAccount(){
		List<User> list= new ArrayList<User>();
		PreparedStatement pst = null;
        Connection con = null;
        ResultSet rs = null;
		try{
			con = DatabaseConnection.getConnection();
			String sql = "SELECT * FROM employee left join user ON employee.EmployeeID = user.EmployeeID "
					+ "left join usertype ON user.UserTypeID = usertype.UserTypeID where user.EmployeeID IS NULL";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				User user = new User();
				user.setEmployeeID(rs.getString(1));
				user.setEmployeeName(rs.getString(2));
				list.add(user);
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
		return list;
	}
	
	public User getUserByUserName(String username){
		User user = null;
		PreparedStatement pst = null;
        Connection con = null;
        ResultSet rs = null;
		con = DatabaseConnection.getConnection();
		String sql = "SELECT * FROM user WHERE Username = ?";
		try{
			pst = con.prepareStatement(sql);
			pst.setString(1, username);
			rs =pst.executeQuery();
			if(rs.next()){
				return new User();
			}
		}catch(Exception e){
			return null;
		}finally {
			try{
				con.close();
				pst.close();
				rs.close();
			}catch(Exception e){
				
			}
		}
		return null;
	}
	
	public boolean createUser(User user) {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {           
            connection = DatabaseConnection.getConnection();
            String sql = "INSERT INTO user (Username, Password, UserTypeID, EmployeeID)"
                       + "VALUES (?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, "12345");
            preparedStatement.setInt(3, user.getUserTypeID());
            preparedStatement.setString(4, user.getEmployeeID());
            preparedStatement.executeUpdate();
        } catch (Exception ex) {
        	
            return false;
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return true;
    }
	
	public boolean deleteUser(String username) {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {           
            connection = DatabaseConnection.getConnection();
            String sql = "DELETE FROM user where Username = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            return false;
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return true;
    }
	
}
