package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.UserType;
import utilities.DatabaseConnection;

public class UserTypeDAO {
	public ArrayList<UserType> getAllUserType() {
		ArrayList<UserType> userTypeList = new ArrayList<>();
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = DatabaseConnection.getConnection();
			String sql = "SELECT * FROM usertype";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				UserType userType = new UserType(resultSet.getInt("UserTypeID"), resultSet.getString("UserTypeName"));
				userTypeList.add(userType);
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
		return userTypeList;
	}
}
