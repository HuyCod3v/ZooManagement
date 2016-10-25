package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bo.RegionBO;
import bo.RegionStatusBO;
import model.Region;
import model.RegionStatus;

@WebServlet("/regions-add")
public class ShowAddRegionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShowAddRegionServlet() {
        super();    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		RegionStatusBO regionStatusBO = new RegionStatusBO();
		List<RegionStatus> statusList = regionStatusBO.getAll();
		request.setAttribute("statusList", statusList);
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("region-add.jsp");	
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}