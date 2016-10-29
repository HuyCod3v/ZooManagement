package model;

public class Notification {
	private int notificationId;
	private String employeeId;
	private String title;
	private String content;
	private String date;
	
	public Notification(){
		
	}
	
	public Notification(int notificationId, String employeeId, String title, String content, String date) {
		super();
		this.notificationId = notificationId;
		this.employeeId = employeeId;
		this.title = title;
		this.content = content;
		this.date = date;
	}

	public int getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(int notificationId) {
		this.notificationId = notificationId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
}
