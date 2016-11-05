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
@WebServlet("/animal-edit")
public class EditAnimal extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditAnimal() {
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

		
		String animalID = request.getParameter("id");
		String submit = request.getParameter("submit");
		
		Animal animal = animalBO.getAnimalById(animalID);
		
		if(submit==null){
			request.setAttribute("animal", animal);
			
			SpeciesBO speciesBO = new SpeciesBO();
			CellBO cellBO = new CellBO();
			
			String errorUpdate = request.getParameter("errorUpdate");
			
			if(errorUpdate!=null){
				request.setAttribute("errorUpdate",errorUpdate);
			}
			
			request.setAttribute("species", speciesBO.getAll());
			request.setAttribute("cells", cellBO.getCellSpace());
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/animal-edit.jsp");
			dispatcher.forward(request, response);
			
		}else{
			
			String animalName = request.getParameter("name-animal");
			int gender = Integer.parseInt(request.getParameter("gender-animal"));
			double weight = Double.parseDouble(request.getParameter("weight"));
			double height = Double.parseDouble(request.getParameter("height"));
			String healthStatus = request.getParameter("health-status");
			String description = request.getParameter("description");
			String cellID = request.getParameter("cell-select");
			String speciesID = request.getParameter("species-select");
			
			Animal animalUpdate = new Animal(animalID, animalName,speciesID, gender, height, weight, healthStatus, description, cellID);
				
				if (animalBO.updateAnimal(animalUpdate)) {
					System.out.println("Update successfully !");
					response.sendRedirect(request.getContextPath() + "/animals?msgUpdate=1");
				} else {
					System.out.println("Update failed !");
					response.sendRedirect(request.getContextPath() + "/animal-edit?errorUpdate=1");
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
