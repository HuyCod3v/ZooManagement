package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.EmployeeBO;
import model.Employee;

/**
 * Servlet implementation class DoCreateEmployee
 */
@WebServlet("/do-create-employee")
public class DoCreateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoCreateEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		EmployeeBO employeeBO = new EmployeeBO();
		String message = null;
		String id = request.getParameter("employeeId");
		String name = request.getParameter("employeeName");
		int gender = Integer.parseInt(request.getParameter("gender"));
		String birthday = request.getParameter("birthday");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		Employee emp = new Employee(id,name,gender,birthday,phone,address);
		request.setAttribute("employee", emp);
		if(id.isEmpty() || name.isEmpty() || birthday.isEmpty() || address.isEmpty()){
			request.setAttribute("message", "Hãy điền đầy đủ thông tin");
			request.getRequestDispatcher("/employee/create-employee.jsp").forward(request, response);
		}else if(employeeBO.getEmployeeById(id) != null){
			request.setAttribute("message", "Mã nhân viên đã tồn tại");
			request.getRequestDispatcher("/employee/create-employee.jsp").forward(request, response);
		}else{
			if(employeeBO.createEmployee(emp)){
				request.getRequestDispatcher("/employee").forward(request, response);
			}else{
				request.setAttribute("message", "Đã xảy ra lỗi");
				request.getRequestDispatcher("/employee/create-employee.jsp").forward(request, response);
			}
		}
		
	}

}
