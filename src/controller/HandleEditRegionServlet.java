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

@WebServlet("/regions-handle-edit")
public class HandleEditRegionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HandleEditRegionServlet() {
        super();    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		String regionID = request.getParameter("regionID");
		String regionName = request.getParameter("regionName");
		float regionArea = Float.parseFloat(request.getParameter("regionArea"));
		int regionStatusID = Integer.parseInt(request.getParameter("regionStatusID"));
		String description = request.getParameter("description");
		Region region = new Region(regionID, regionName, regionStatusID, regionArea, description);
	
		RegionBO regionBO = new RegionBO();
		
		if (regionBO.edit(region) == true) {
			response.sendRedirect(request.getContextPath() + "/regions");	
		} else {
			request.setAttribute("region", region);
			RequestDispatcher dispatcher = request.getRequestDispatcher("region-edit.jsp");
		}
		
		
	}

}