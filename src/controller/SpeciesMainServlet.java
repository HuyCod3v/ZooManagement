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
import bo.SpeciesBO;
import model.Region;
import model.Species;

@WebServlet("/species")
public class SpeciesMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SpeciesMainServlet() {
        super();    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		SpeciesBO speciesBO = new SpeciesBO();
		List<Species> species = speciesBO.getAll();
	
		request.setAttribute("species", species);
		RequestDispatcher dispatcher = request.getRequestDispatcher("species-main.jsp");	
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
