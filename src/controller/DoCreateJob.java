package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.JobBO;
import bo.NotificationBO;
import model.Job;
import model.Notification;
import model.User;

/**
 * Servlet implementation class DoCreateJob
 */
@WebServlet("/job/do-create-job")
public class DoCreateJob extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoCreateJob() {
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
		JobBO jobBO = new JobBO();
		
		String ma = request.getParameter("jobId");
		String ten = request.getParameter("jobName");
		String mt = request.getParameter("des");
		
		Job job = new Job();
		job.setJobId(ma);
		job.setJobName(ten);
		job.setDescription(mt);
		
		if(ma.isEmpty() || ten.isEmpty()) {
			request.setAttribute("message","Hãy Điền Đầy Đủ Thông Tin");
			request.getRequestDispatcher("/job/create-job.jsp").forward(request, response);
		}else if(jobBO.getJobById(ma)!=null){
			request.setAttribute("message","Đã tồn tại mã công việc");
			request.getRequestDispatcher("/job/create-job.jsp").forward(request, response);
		}else {
			if(jobBO.creatJob(job)){
				response.sendRedirect(request.getContextPath()+"/job");
			}else{
				request.setAttribute("message","Đã xảy ra lỗi ");
				request.getRequestDispatcher("/job/create-job.jsp").forward(request, response);
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
