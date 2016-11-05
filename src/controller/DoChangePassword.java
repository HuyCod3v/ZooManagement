package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.UserBO;
import model.User;

/**
 * Servlet implementation class DoChangePassword
 */
@WebServlet("/do-change-password")
public class DoChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoChangePassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User)request.getSession().getAttribute("user");
		String password = request.getParameter("password");
		String passwordNew = request.getParameter("password-new");
		String passwordRe = request.getParameter("password-re");
		
		UserBO userBO = new UserBO();
		if(password.isEmpty() || passwordNew.isEmpty() || passwordRe.isEmpty()){
			request.setAttribute("message","Nhập mật khẩu đầy đủ");
			request.getRequestDispatcher("/user/settings.jsp").forward(request, response);
		}else if(!passwordNew.equals(passwordRe)){
			request.setAttribute("message","Mật khẩu không trùng nhau");
			request.getRequestDispatcher("/user/settings.jsp").forward(request, response);
		}
		else if(!user.getPassword().equals(password)){
			request.setAttribute("message","Không đúng mật khẩu cũ");
			request.getRequestDispatcher("/user/settings.jsp").forward(request, response);
		}else{
			if(userBO.changePassword(user, passwordNew)){
				response.sendRedirect(request.getContextPath()+"/employee");
			}else{
				request.setAttribute("message","Xảy ra lỗi khi cập nhật password");
				request.getRequestDispatcher("/user/settings.jsp").forward(request, response);
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
