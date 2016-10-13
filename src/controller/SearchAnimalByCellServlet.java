package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.AnimalBO;
import model.Animal;

@WebServlet("/animals_by_cell")
public class SearchAnimalByCellServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchAnimalByCellServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		String cellId = request.getParameter("cell_id");
		ArrayList<Animal> animalList = new AnimalBO().searchAnimalByCell(cellId);
		request.setAttribute("animal_list", animalList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("animal_table.jsp");
		dispatcher.forward(request, response);
	}

}
