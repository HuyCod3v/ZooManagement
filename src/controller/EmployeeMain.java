package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import model.User;


/**
 * Servlet implementation class EmployeeMain
 */
public class EmployeeMain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeMain() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		UserDAO userDAO = new UserDAO();
		HttpSession session = request.getSession();
		User sUser = (User)session.getAttribute("sUser");
		String submit = request.getParameter("submit");
		if(submit==null){
			response.sendRedirect(request.getContextPath()+"/employee.jsp");
		}else{
			int genderValue=0;
			String employeeName = request.getParameter("employeename");
			String gender = request.getParameter("gender");
			if("Nam".equals(gender)){
				genderValue =1;
			}
			String birthday = request.getParameter("birthday");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			User user = new model.User(employeeName, genderValue, birthday, phone, address);
			userDAO.upadateUser(user,sUser.getEmployeeID());
			response.sendRedirect(request.getContextPath()+"/info-user?id="+user.getEmployeeID());
		}
	}

}
