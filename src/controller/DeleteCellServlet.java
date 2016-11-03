package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.CellBO;

/**
 * Servlet implementation class CellMainServlet
 */
@WebServlet("/cell-del")
public class DeleteCellServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCellServlet() {
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
		
		System.out.println("OK");
		
		CellBO cellBO = new CellBO();
		
		String cellID = request.getParameter("cellID");
		
		
		
		if(cellBO.deleteCell(cellID)){
			System.out.println("Delete cell successfully !");
			response.sendRedirect(request.getContextPath()+"/cells?msgDel=1");
		}else{
			System.out.println("Delete cell failed !");
			response.sendRedirect(request.getContextPath()+"/cells");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
