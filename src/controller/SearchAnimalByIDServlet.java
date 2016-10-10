package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Animal;
import dao.AnimalBO;

@WebServlet("/animals_by_id")
public class SearchAnimalByIDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SearchAnimalByIDServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String animalId = request.getParameter("animal_id");	
		response.setContentType("text/html");
		request.setAttribute("key_search", animalId);
		response.setCharacterEncoding("utf-8");
		request.setAttribute("key_search", animalId);
		ArrayList<Animal> animalList = new AnimalBO().searchAnimalById(animalId);
		request.setAttribute("animal_list", animalList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("animal_table.jsp");
		dispatcher.forward(request, response);
	}

}
