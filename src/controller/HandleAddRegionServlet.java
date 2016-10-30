package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.RegionBO;
import model.Region;

@WebServlet("/regions-handle-add")
public class HandleAddRegionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HandleAddRegionServlet() {
        super();    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		String regionID = request.getParameter("regionID");
		String regionName = request.getParameter("regionName");
		float regionArea = Float.parseFloat(request.getParameter("regionArea"));
		int regionStatusID = Integer.parseInt(request.getParameter("regionStatusID"));
		String description = request.getParameter("description");
		Region region = new Region(regionID, regionName, regionStatusID, regionArea, description);
	
		RegionBO regionBO = new RegionBO();
		
		if (regionBO.add(region) == true) {
			request.setAttribute("success", "Thêm khu vực mới thành công");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/regions");
			dispatcher.forward(request, response);
		} else {
			request.setAttribute("error", "Có lỗi trong quá trình tạo khu vực. Vui lòng thử lại!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/regions-add");
			dispatcher.forward(request, response);
		}
		
		
	}

}