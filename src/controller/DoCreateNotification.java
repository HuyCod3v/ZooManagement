package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.NotificationBO;
import model.Notification;
import model.User;

/**
 * Servlet implementation class DoCreateNotification
 */
@WebServlet("/notification/do-create-notification")
public class DoCreateNotification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoCreateNotification() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		NotificationBO notiBO = new NotificationBO();
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		Notification noti = new Notification();
		noti.setContent(content);
		noti.setTitle(title);
		noti.setEmployeeId(((User)request.getSession().getAttribute("user")).getEmployeeID());
		if(title.isEmpty() || content.isEmpty()) {
			request.setAttribute("message","Hãy Điền Đầy Đủ Thông Tin");
			request.getRequestDispatcher("/notification/create-notification.jsp").forward(request, response);
		}else {
			if(notiBO.createNotification(noti)){
				response.sendRedirect(request.getContextPath()+"/notification");
			}else{
				request.setAttribute("message","Đã xảy ra lỗi ");
				request.getRequestDispatcher("/notification/create-notification.jsp").forward(request, response);
			}
		}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
