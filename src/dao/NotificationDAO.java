package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import model.Employee;
import model.Notification;
import model.User;
import utilities.DatabaseConnection;

public class NotificationDAO {
	public ArrayList<Notification> getAllNotification() {
		ArrayList<Notification> list = new ArrayList<>();
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = DatabaseConnection.getConnection();
			String sql = "SELECT * FROM Notification order by NotificationDate DESC";
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
            String sql = "INSERT INTO Notification (EmployeeID, Title, Content)"
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
	
	public boolean deleteNotification(String id) {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {           
            connection = DatabaseConnection.getConnection();
            String sql = "DELETE FROM Notification where NotificationID = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
           return  preparedStatement.executeUpdate() == 1 ? true : false;
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
	
	public boolean userOwnNoti(String userid,String notiId){
		PreparedStatement pst = null;
        Connection con = null;
        ResultSet rs = null;
		con = DatabaseConnection.getConnection();
		String sql = "SELECT * FROM User inner join Employee ON User.EmployeeID = Employee.EmployeeID"
				+ " inner join Notification on Employee.EmployeeID = Notification.EmployeeID"
				+ " WHERE User.Username = ? AND Notification.NotificationID = ?";
		try{
			pst = con.prepareStatement(sql);
			pst.setString(1, userid);
			pst.setString(2, notiId);
			rs =pst.executeQuery();
			if(rs.next()){
				return true;
			}else {
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally {
			try{
				con.close();
				pst.close();
				rs.close();
			}catch(Exception e){
				
			}
		}
	}
	
	public Notification getNotificationById(String notiId) {
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = DatabaseConnection.getConnection();
			String sql = "SELECT * FROM Notification where NotificationID = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, notiId);
			resultSet = preparedStatement.executeQuery();
			Notification notification = null;
			if(resultSet.next())
				 notification = new Notification(resultSet.getInt(1),resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getString(4),
						resultSet.getString(5));
			return notification;
		} catch (Exception ex) {
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (Exception ex) {
			}
		}
		return null;
	}
	
	public boolean updateNotification(String notiId,String title, String content) {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {           
            connection = DatabaseConnection.getConnection();
            String sql = "UPDATE  Notification SET  Title = ?, Content = ? WHERE NotificationID = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, content);
            preparedStatement.setString(3, notiId );
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
