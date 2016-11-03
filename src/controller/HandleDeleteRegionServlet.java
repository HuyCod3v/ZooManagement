package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.CellBO;
import bo.RegionBO;

@WebServlet("/regions-handle-delete")
public class HandleDeleteRegionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HandleDeleteRegionServlet() {
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
	
		RegionBO regionBO = new RegionBO();
		CellBO cellBO = new CellBO();
		
		int cellQuantity = cellBO.getByRegion(regionID).size();
		if (cellQuantity > 0) {
			request.setAttribute("error", "Không thể xóa khu vực còn các chuồng bên trong. Vui lòng xóa các chuồng của khu vực này trước!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/regions");
			dispatcher.forward(request, response);
			return;
		}
		
		if (regionBO.delete(regionID) == true) {
			request.setAttribute("success", "Xóa khu vực thành công");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/regions");
			dispatcher.forward(request, response);
		} else {
			request.setAttribute("error", "Có lỗi trong quá trình xóa khu vực. Vui lòng thử lại!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/regions");
			dispatcher.forward(request, response);
		}
			
	}

}