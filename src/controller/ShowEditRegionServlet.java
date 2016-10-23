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

@WebServlet("/regions-edit")
public class ShowEditRegionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShowEditRegionServlet() {
        super();    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		String regionID = request.getParameter("id");
		RegionBO regionBO = new RegionBO();
		Region region = regionBO.find(regionID);
		request.setAttribute("region", region);
		
		RegionStatusBO regionStatusBO = new RegionStatusBO();
		List<RegionStatus> statusList = regionStatusBO.getAll();
		request.setAttribute("statusList", statusList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("region-edit.jsp");	
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}