package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import model.User;
public class ChangePassUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ChangePassUser() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		User sUser = (User) session.getAttribute("sUser");
		UserDAO userDAO = new UserDAO();
		String submit = request.getParameter("submit");
		if(submit==null){
			response.sendRedirect(request.getContextPath()+"/changepass.jsp");
		}else{
			String old_password = request.getParameter("old_password");
			if(old_password.equals(sUser.getPassword())){
				String password = request.getParameter("new_password");
				User user = new User(sUser.getUsername(), password);
				userDAO.editPassword(user);
				response.sendRedirect(request.getContextPath()+"/info-user?msg=1");
			}else{
				response.sendRedirect(request.getContextPath()+"/changepass.jsp?msg=0");
			}
		}
	}

}
