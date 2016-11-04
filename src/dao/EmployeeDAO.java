package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Employee;
import model.User;
import utilities.DatabaseConnection;

public class EmployeeDAO {
	public ArrayList<Employee> getAllEmployee() {
		ArrayList<Employee> employeeList = new ArrayList<>();
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = DatabaseConnection.getConnection();
			String sql = "SELECT * FROM employee";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Employee employee = new Employee(resultSet.getString("EmployeeID"),
						resultSet.getString("EmployeeName"),
						resultSet.getInt("Gender"),
						resultSet.getString("Birthday"),
						resultSet.getString("Phone"),
						resultSet.getString("Address"));
				employeeList.add(employee);
			}
		} catch (Exception ex) {
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (Exception ex) {
			}
		}
		return employeeList;
	}
	
	public Employee getEmployeeById(String id){
		Employee user = null;
		PreparedStatement pst = null;
        Connection con = null;
        ResultSet rs = null;
		con = DatabaseConnection.getConnection();
		String sql = "SELECT * FROM employee WHERE EmployeeID = ?";
		try{
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			rs =pst.executeQuery();
			if(rs.next()){
				user = new Employee(rs.getString("EmployeeID"),
						rs.getString("EmployeeName"),
						rs.getInt("Gender"),
						rs.getString("Birthday"),
						rs.getString("Phone"),
						rs.getString("Address")
						);
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
	public boolean createEmployee(Employee employee) {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {           
            connection = DatabaseConnection.getConnection();
            String sql = "INSERT INTO employee (EmployeeID, EmployeeName, Gender, Birthday, Phone, Address)"
                       + "VALUES (?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, employee.getEmployeeId());
            preparedStatement.setString(2, employee.getEmployeeName());
            preparedStatement.setInt(3, employee.getGender());
            preparedStatement.setString(4, employee.getBirthday());
            preparedStatement.setString(5, employee.getPhone());
            preparedStatement.setString(6, employee.getAddress());
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
	
	public boolean editEmployee(Employee employee) {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {           
            connection = DatabaseConnection.getConnection();
            String sql = "UPDATE  employee SET EmployeeName = ?, Gender = ?, Birthday = ?, Phone = ?, Address = ? WHERE EmployeeID = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, employee.getEmployeeName());
            preparedStatement.setInt(2, employee.getGender());
            preparedStatement.setString(3, employee.getBirthday());
            preparedStatement.setString(4, employee.getPhone());
            preparedStatement.setString(5, employee.getAddress());
            preparedStatement.setString(6, employee.getEmployeeId());
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
	
	public boolean deleteEmployee(String id) {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {           
            connection = DatabaseConnection.getConnection();
            String sql = "DELETE FROM employee where EmployeeID = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            return preparedStatement.executeUpdate() == 1 ? true : false;
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
    }
}
