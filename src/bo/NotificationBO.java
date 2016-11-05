package bo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.NotificationDAO;
import model.Notification;
import utilities.DatabaseConnection;

public class NotificationBO {
	public ArrayList<Notification> getAllNotification() {
		return new NotificationDAO().getAllNotification();
	}
	
	public boolean createNotification(Notification noti){
		return new NotificationDAO().createNotification(noti);
	}
	public boolean deleteNotification(String id) {
		return new NotificationDAO().deleteNotification(id);
	}
	public boolean userOwnNoti(String userid,String notiId){
		return new NotificationDAO().userOwnNoti(userid, notiId);
	}
	public Notification getNotificationById(String notiId) {
		return new NotificationDAO().getNotificationById(notiId);
	}
	public boolean updateNotification(String notiId,String title, String content) {
		return new NotificationDAO().updateNotification(notiId, title, content);
	}
}
