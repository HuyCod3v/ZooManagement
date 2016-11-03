package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.CellBO;
import bo.CellStatusBO;
import bo.RegionBO;
import bo.SpeciesBO;
import model.Cell;

/**
 * Servlet implementation class CellMainServlet
 */
@WebServlet("/cell-edit")
public class EditCellServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditCellServlet() {
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
		String cellID = request.getParameter("id");
		String submit = request.getParameter("submit");
		
		Cell cell = cellBO.getCellByID(cellID);
		
		if(submit==null){
			request.setAttribute("cell", cell);
			
			RegionBO regionBO = new RegionBO();
			SpeciesBO speciesBO = new SpeciesBO();
			CellStatusBO cellStatusBO = new CellStatusBO();
			
			String errorUpdate = request.getParameter("errorUpdate");
			
			if(errorUpdate!=null){
				request.setAttribute("errorUpdate",errorUpdate);
			}
			
			request.setAttribute("regions", regionBO.getAll());
			request.setAttribute("species", speciesBO.getAllSpecies());
			request.setAttribute("status", cellStatusBO.getAll());
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/cell-edit.jsp");
			dispatcher.forward(request, response);
			
		}else{
			
			String cellName = request.getParameter("name-cell");
			int capacity = Integer.parseInt(request.getParameter("capacity"));
			String description = request.getParameter("description");
			String regionID = request.getParameter("region-select");
			String speciesID = request.getParameter("species-select");
			int cellStatusID = Integer.parseInt(request.getParameter("cell-status"));

			Cell cellEdit = new Cell(cellID, cellName, regionID, speciesID, capacity, cellStatusID, description);
				
				if (cellBO.updateCell(cellEdit)) {
					System.out.println("Update successfully !");
					response.sendRedirect(request.getContextPath() + "/cells?msgUpdate=1");
				} else {
					System.out.println("Update failed !");
					response.sendRedirect(request.getContextPath() + "/cell-edit?errorUpdate=1");
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
