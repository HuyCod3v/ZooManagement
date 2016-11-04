package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.EmployeeBO;

/**
 * Servlet implementation class DoDeleteEmployee
 */
@WebServlet("/do-delete-employee")
public class DoDeleteEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoDeleteEmployee() {
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
		EmployeeBO ebo  = new EmployeeBO();
		String id = request.getParameter("employee-id");
		if(ebo.deleteEmployee(request.getParameter(id))){
			response.sendRedirect(request.getContextPath()+"/employee");
			System.out.println("DELETE");
		}else{
			request.setAttribute("error","Đã xảy ra lỗi khi xóa nhân viên "+id);
			request.getRequestDispatcher("/employee").forward(request, response);
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
