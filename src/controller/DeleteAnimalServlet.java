package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AnimalBO;

@WebServlet("/delete_animal")
public class DeleteAnimalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteAnimalServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String animalId = request.getParameter("animal_id");
		if (!animalId.equals("")) {
			AnimalBO animalBO = new AnimalBO();
			boolean success = animalBO.deleteAnimal(animalId);
			if (success) {
				response.sendRedirect(request.getContextPath() + "/animal-management");
			}
			else {
				response.sendRedirect(request.getContextPath() + "/update_animal");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
