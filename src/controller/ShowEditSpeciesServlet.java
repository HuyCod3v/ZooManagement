package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.SpeciesBO;
import model.Species;

@WebServlet("/species-edit")
public class ShowEditSpeciesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShowEditSpeciesServlet() {
        super();    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		String id = request.getParameter("id");
		SpeciesBO speciesBO = new SpeciesBO();
		Species species = speciesBO.find(id);
		request.setAttribute("species", species);
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("species-edit.jsp");	
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}