package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.CellBO;
import model.Cell;

/**
 * Servlet implementation class CellMainServlet
 */
@WebServlet("/cell-add")
public class AddCellServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCellServlet() {
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

		CellBO cellBO = new CellBO();

		String cellID = request.getParameter("id-cell");
		String cellName = request.getParameter("name-cell");
		int capacity = Integer.parseInt(request.getParameter("capacity"));
		String description = request.getParameter("description");
		String regionID = request.getParameter("region-select");
		String speciesID = request.getParameter("species-select");
		int cellStatusID = Integer.parseInt(request.getParameter("cell-status"));

		Cell cell = new Cell(cellID, cellName, regionID, speciesID, capacity, cellStatusID, description);

		if (cellBO.checkExistCell(cellID)) {
			System.out.println("Cell is existed ");
			
			request.setAttribute("cell", cell);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/cell-add-view?error=1");
			dispatcher.forward(request, response);
			
			
		} else {

			if (cellBO.addCell(cell)) {
				System.out.println("Add successfully !");
				response.sendRedirect(request.getContextPath() + "/cells?msgAdd=1");
			} else {
				System.out.println("Add fail");
				response.sendRedirect(request.getContextPath() + "/cell-add-view");
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
