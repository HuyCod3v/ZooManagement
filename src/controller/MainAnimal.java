package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.AnimalBO;

/**
 * Servlet implementation class CellMainServlet
 */
@WebServlet("/animals")
public class MainAnimal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainAnimal() {
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
		request.setAttribute("animals", animalBO.getAllAnimals());
		
		String msgAdd = request.getParameter("msgAdd");
		
		String msgUpdate = request.getParameter("msgUpdate");
		String msgDel = request.getParameter("msgDel");
		request.setAttribute("msgAdd", msgAdd);
		request.setAttribute("msgUpdate", msgUpdate);
		request.setAttribute("msgDel", msgDel);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("animal-main.jsp");
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
