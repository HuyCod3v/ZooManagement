package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AnimalDAO;
import dao.CellDAO;
import dao.RegionDAO;
import dao.SpeciesDAO;
import model.Animal;
import model.Cell;
import model.Region;
import model.Species;

/**
 * Servlet implementation class AddAnimalServlet
 */
@WebServlet(name = "AddAnimalServlet", urlPatterns = {"/AddAnimalServlet"})
public class AddAnimalServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAnimalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean ok;
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        String speciesID = request.getParameter("species_id");
        String animalID = request.getParameter("animal_id");
        String animalName = request.getParameter("animal_name");
        String genderStr = request.getParameter("gender");
        int gender;
        if (genderStr.equals("male")) {
            gender = 1;
        } else {
            gender = 0;
        }
        String weight = request.getParameter("weight");
        String height = request.getParameter("height");
        String healthStatus = request.getParameter("health_status");
        String description = request.getParameter("description");
        String cellID = request.getParameter("cell_id");

        Animal animal = new Animal(animalID, animalName, speciesID, gender, healthStatus, cellID);
        if (!"".equals(weight)) animal.setWeight(Double.parseDouble(weight));
        if (!"".equals(height)) animal.setHeight(Double.parseDouble(height));
        if (!"".equals(description)) animal.setDescription(description);
                                   
//        Animal animal = new Animal(animalID, animalName, speciesID, gender,
//                                   Double.parseDouble(height), Double.parseDouble(weight),
//                                   healthStatus, description, cellID);
        ok = new AnimalDAO().add(animal);
        if (ok) {
            response.sendRedirect(request.getContextPath() + "/animal-management");
        } else {
            response.sendRedirect(request.getContextPath() + "/add-animal");
        }
    }

}
