package controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import model.User;

public class CheckLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CheckLogin() {
        super();
        
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	doPost(req, resp);
    }
     

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		
		UserDAO userDAO = new UserDAO();
		
		String submit = request.getParameter("submit");
		
		if(submit==null){
			response.sendRedirect(request.getContextPath()+"/dang-nhap.jsp");
		}else{
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			User user =userDAO.checkUserLogin(username, password);
			session.setAttribute("sUser", user);
			if(user!=null){
				response.sendRedirect(request.getContextPath()+"/ShowInfUser");
			}else{
				response.sendRedirect(request.getContextPath()+"/dang-nhap.jsp?msg=0");
			}
		}
	}

}
