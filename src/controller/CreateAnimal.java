package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.AnimalBO;
import model.Animal;

/**
 * Servlet implementation class CellMainServlet
 */
@WebServlet("/animal-add")
public class CreateAnimal extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateAnimal() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		AnimalBO animalBO = new AnimalBO();

		String animalID = request.getParameter("id-animal");
		String animalName = request.getParameter("name-animal");
		int gender = Integer.parseInt(request.getParameter("gender-animal"));
		double weight = Double.parseDouble(request.getParameter("weight"));
		double height = Double.parseDouble(request.getParameter("height"));
		String healthStatus = request.getParameter("health-status");
		String description = request.getParameter("description");
		String speciesID = request.getParameter("species-select");
		String cellID = request.getParameter("cell-select");
		
		Animal animal = new Animal(animalID, animalName,speciesID, gender, height, weight, healthStatus, description, cellID);

		if (animalBO.checkExistAnimal(animalID)) {
			
			System.out.println("des "+animal.getDescription());
			
			System.out.println("Animal is existed ");
			
			request.setAttribute("animal", animal);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/animal-add-view?error=1");
			dispatcher.forward(request, response);
			
			
		} else {

			if (animalBO.addAnimal(animal)) {
				System.out.println("Add successfully !");
				response.sendRedirect(request.getContextPath() + "/animals?msgAdd=1");
			} else {
				System.out.println("Add fail");
				response.sendRedirect(request.getContextPath() + "/animal-add-view");
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
