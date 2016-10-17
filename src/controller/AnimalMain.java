package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.CellBO;
import bo.RegionBO;
import bo.SpeciesBO;
import dao.AnimalDAO;
import dao.RegionDAO;
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
		List<Animal> animalList = new AnimalDAO().getAll();	
		List<Region> regionList = new RegionBO().getAll();
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
