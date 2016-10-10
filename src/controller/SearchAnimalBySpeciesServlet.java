package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AnimalBO;
import model.Animal;

@WebServlet("/animals_by_species")
public class SearchAnimalBySpeciesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SearchAnimalBySpeciesServlet() {
        super();   
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		String speciesId = request.getParameter("species_id");
		ArrayList<Animal> animalList = new AnimalBO().searchAnimalBySpecies(speciesId);
		request.setAttribute("animal_list", animalList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("animal_table.jsp");
		dispatcher.forward(request, response);
	}

}
