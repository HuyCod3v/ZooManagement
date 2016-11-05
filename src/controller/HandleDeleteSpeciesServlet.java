package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.AnimalBO;
import bo.SpeciesBO;

@WebServlet("/species-handle-delete")
public class HandleDeleteSpeciesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HandleDeleteSpeciesServlet() {
        super();    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		String speciesID = request.getParameter("speciesID");
	
		SpeciesBO speciesBO = new SpeciesBO();
		AnimalBO animalBO = new AnimalBO();
		
		if (speciesBO.delete(speciesID) == true) {
			request.setAttribute("success", "Xóa loài thành công");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/species");
			dispatcher.forward(request, response);
		} else {
			request.setAttribute("error", "Có lỗi trong quá trình xóa loài. Vui lòng thử lại!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/species");
			dispatcher.forward(request, response);
		}
			
	}

}