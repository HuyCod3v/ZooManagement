package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.NotificationBO;
import model.User;

/**
 * Servlet implementation class DeleteNotification
 */
@WebServlet("/delete-noti")
public class DeleteNotification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteNotification() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NotificationBO notiBO = new NotificationBO();
		User user = (User)request.getSession().getAttribute("user");
		if(notiBO.userOwnNoti(user.getUsername(), request.getParameter("notiId"))
				&& notiBO.deleteNotification(request.getParameter("notiId"))){
			response.sendRedirect(request.getContextPath()+"/notification");
		}else{
			request.setAttribute("message","Xảy ra lỗi khi xóa 1 thông báo");
			request.getRequestDispatcher("/notification").forward(request, response);
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
