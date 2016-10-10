package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AnimalDAO;
import dao.CellBO;
import dao.RegionBO;
import dao.RegionDAO;
import dao.SpeciesBO;
import model.Animal;
import model.Cell;
import model.Region;
import model.Species;

/**
 * Servlet implementation class AnimalMain
 */
public class AnimalMain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnimalMain() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		ArrayList<Animal> animalList = new AnimalDAO().getAllAnimals();	
		ArrayList<Region> regionList = new RegionBO().getAllRegions();
		ArrayList<Cell> cellList = new CellBO().getAllCells();
		ArrayList<Species> speciesList = new SpeciesBO().getAllSpecies();
		request.setAttribute("animal_list", animalList);
		request.setAttribute("region_list", regionList);
		request.setAttribute("cell_list", cellList);
		request.setAttribute("species_list", speciesList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("qldv-main.jsp");	
		dispatcher.forward(request, response);
		
		
	}

}
