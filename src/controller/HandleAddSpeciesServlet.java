package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.SpeciesBO;
import model.Species;

@WebServlet("/species-handle-add")
public class HandleAddSpeciesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HandleAddSpeciesServlet() {
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
		String speciesName = request.getParameter("speciesName");
		String description = request.getParameter("description");
		Species species = new Species(speciesID, speciesName, description);
	
		SpeciesBO speciesBO = new SpeciesBO();
		
		if (speciesBO.find(speciesID) != null) {
			request.setAttribute("error", "Mã loài đã tồn tại. Vui lòng thử lại!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/species-add");
			dispatcher.forward(request, response);
		}
		
		else if (speciesBO.add(species) == true) {
			request.setAttribute("success", "Thêm loài mới thành công");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/species");
			dispatcher.forward(request, response);
		} else {
			request.setAttribute("error", "Có lỗi trong quá trình tạo loài. Vui lòng thử lại!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/species-add");
			dispatcher.forward(request, response);
		}
		
		
	}

}