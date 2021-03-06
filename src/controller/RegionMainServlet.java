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
import model.Region;

@WebServlet("/regions")
public class RegionMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegionMainServlet() {
        super();    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		RegionBO regionBO = new RegionBO();
		List<Region> regions = regionBO.getAll();
	
		request.setAttribute("regions", regions);
		RequestDispatcher dispatcher = request.getRequestDispatcher("region-main.jsp");	
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
