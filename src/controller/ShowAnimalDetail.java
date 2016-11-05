package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.AnimalBO;
import bo.CellBO;
import bo.SpeciesBO;
import model.Animal;

/**
 * Servlet implementation class CellMainServlet
 */
@WebServlet("/animal-view")
public class ShowAnimalDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAnimalDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		AnimalBO animalBO = new AnimalBO();

		String animalID = request.getParameter("id");
		
		Animal animal = animalBO.getAnimalById(animalID);
		
		SpeciesBO speciesBO = new SpeciesBO();
		CellBO cellBO = new CellBO();
		
		request.setAttribute("animal", animal);
		request.setAttribute("species", speciesBO.getAllSpecies());
		request.setAttribute("cells", cellBO.getCellSpace());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/animal-view.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
