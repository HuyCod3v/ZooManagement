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

@WebServlet("/regions-handle-delete")
public class HandleDeleteRegionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HandleDeleteRegionServlet() {
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
	
		RegionBO regionBO = new RegionBO();
		
		if (regionBO.delete(regionID) == true) {
			response.sendRedirect(request.getContextPath() + "/regions");	
		} else {
			response.sendRedirect(request.getContextPath() + "/regions-add");
		}
		
		
	}

}