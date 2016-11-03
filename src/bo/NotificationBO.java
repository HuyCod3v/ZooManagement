package bo;

import java.util.ArrayList;

import dao.NotificationDAO;
import model.Notification;

public class NotificationBO {
	public ArrayList<Notification> getAllNotification() {
		return new NotificationDAO().getAllNotification();
	}
	
	public boolean createNotification(Notification noti){
		return new NotificationDAO().createNotification(noti);
	}
}
