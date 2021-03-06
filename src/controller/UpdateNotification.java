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
 * Servlet implementation class DetailNotification
 */
@WebServlet("/notification/update")
public class UpdateNotification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateNotification() {
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
		User user = (User)request.getSession().getAttribute("user");
		String notiId = request.getParameter("notification");
		Notification noti = notiBO.getNotificationById(notiId);
		if(notiBO.userOwnNoti(user.getUsername(),notiId)){
			request.setAttribute("noti", noti);
			request.getRequestDispatcher("/notification/update.jsp").forward(request, response);
		}else{
			response.sendRedirect(request.getContextPath()+"/notification");
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
