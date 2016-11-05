package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import model.Notification;
import utilities.DatabaseConnection;

public class NotificationDAO {
	public ArrayList<Notification> getAllNotification() {
		ArrayList<Notification> list = new ArrayList<>();
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = DatabaseConnection.getConnection();
			String sql = "SELECT * FROM notification order by NotificationDate DESC";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Notification notification = new Notification(resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getString(4),
						resultSet.getString(5));
				list.add(notification);
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
		return list;
	}
	
	public boolean createNotification(Notification noti) {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {           
            connection = DatabaseConnection.getConnection();
            String sql = "INSERT INTO notification (EmployeeID, Title, Content)"
                       + "VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, noti.getEmployeeId());
            preparedStatement.setString(2, noti.getTitle());
            preparedStatement.setString(3, noti.getContent());
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
