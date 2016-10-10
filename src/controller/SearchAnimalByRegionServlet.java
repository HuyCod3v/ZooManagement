package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AnimalBO;
import model.Animal;

@WebServlet("/animals_by_region")
public class SearchAnimalByRegionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SearchAnimalByRegionServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		String regionId = request.getParameter("region_id");
		ArrayList<Animal> animalList = new AnimalBO().searchAnimalByRegion(regionId);
		request.setAttribute("animal_list", animalList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("animal_table.jsp");
		dispatcher.forward(request, response);
	}

}
