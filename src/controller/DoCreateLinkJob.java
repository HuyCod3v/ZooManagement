package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.LinkJobEmployeeBO;
import model.LinkJobEmployee;

/**
 * Servlet implementation class DoCreateLinkJob
 */
@WebServlet("/link-job/do-create-link-job")
public class DoCreateLinkJob extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoCreateLinkJob() {
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
		
		LinkJobEmployeeBO linkBO = new LinkJobEmployeeBO();
		LinkJobEmployee link =  new LinkJobEmployee();
		link.getEmployee().setEmployeeId(request.getParameter("employeeId"));
		link.getJob().setJobId(request.getParameter("jobId"));
		link.setStartTime(request.getParameter("startTime"));
		link.setEndTime(request.getParameter("endTime"));
		link.setDescription(request.getParameter("description"));
		
		if(linkBO.createLinkJob(link)){
			response.sendRedirect(request.getContextPath()+"/link-job");
		}else{
			request.setAttribute("message", "Không tạo công việc");
			request.getRequestDispatcher("/link-job/create").forward(request, response);
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
