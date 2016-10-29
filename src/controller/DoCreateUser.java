package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.UserBO;
import bo.UserTypeBO;
import model.User;

/**
 * Servlet implementation class DoCreateUser
 */
@WebServlet("/manager/do-create-user")
public class DoCreateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoCreateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		UserBO userBO = new UserBO();
		UserTypeBO userTypeBO = new UserTypeBO();
		
		request.setAttribute("listUserType", userTypeBO.getAllUserType());
		request.setAttribute("listUser", userBO.listAllUserNoAccount());
		String message = null;
		String username = request.getParameter("username");
		int userTypeId = Integer.parseInt(request.getParameter("userTypeId"));
		String employeeId = request.getParameter("employeeId");
		User user = new User();
		request.setAttribute("user",user);
		user.setUsername(username);
		user.setEmployeeID(employeeId);
		user.setUserTypeID(userTypeId);
		
		if(username.isEmpty() || username.contains(" ") || username == null){
			request.setAttribute("message", "Nhập đầy đủ thông tin");
			request.getRequestDispatcher("/user/create-user.jsp").forward(request, response);
		}else if(userBO.getUserByUserName(username) != null){
			request.setAttribute("message", "Tên Tài Khoản đã tồn tại");
			request.getRequestDispatcher("/user/create-user.jsp").forward(request, response);
		}else{
			if(userBO.createUser(user)){
				request.getRequestDispatcher("/manager").forward(request, response);
			}else{
				request.setAttribute("message", "Đã xảy ra lỗi");
				request.getRequestDispatcher("/user/create-user.jsp").forward(request, response);
			}
		}
	}

}
