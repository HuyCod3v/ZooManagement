package controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

/**
 * Servlet Filter implementation class PermissionNormalUser
 */
@WebFilter( urlPatterns ={"/*"})
public class PermissionNormalUser implements Filter {

    /**
     * Default constructor. 
     */
    public PermissionNormalUser() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	 private static final Set<String> ALLOWED_PATHS = Collections.unmodifiableSet(new HashSet<>(
		        Arrays.asList("","/logout","/login")));

		    @Override
		    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		        HttpServletRequest request = (HttpServletRequest) req;
		        HttpServletResponse response = (HttpServletResponse) res;
		        HttpSession session = request.getSession();
		        User user = (User)session.getAttribute("user");
		        String path = request.getRequestURI().substring(request.getContextPath().length()).replaceAll("[/]+$", ""); 

		        boolean loggedIn = (user != null);
		        boolean allowedPath = ALLOWED_PATHS.contains(path);

		        if (loggedIn || allowedPath) {
		            chain.doFilter(req, res);
		        }
		        else {
		            response.sendRedirect(request.getContextPath() + "/");
		        }
		    }


	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
