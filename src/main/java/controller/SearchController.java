package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SearchDao;
import model.Customer;

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("search")) {
			
			String searchby = request.getParameter("searchby");  // search filter
			System.out.println(searchby);
			String usersearch = request.getParameter("usersearch"); // user search
			
			// search by first name
			if(searchby.equalsIgnoreCase("firstname")) {
				
				request.setAttribute("firstname", usersearch);
				request.getRequestDispatcher("searchbyfirstname.jsp").forward(request, response);
				
				// search by city
			}else if(searchby.equalsIgnoreCase("city")) {
				request.setAttribute("city", usersearch);
				request.getRequestDispatcher("searchbycity.jsp").forward(request, response);
				
				// search by email
			}else if(searchby.equalsIgnoreCase("email")) {
				request.setAttribute("email", usersearch);
				request.getRequestDispatcher("searchbyemail.jsp").forward(request, response);
				
				// search by phone
			}else if(searchby.equalsIgnoreCase("phone")) {
				
				request.setAttribute("phone", usersearch);
				request.getRequestDispatcher("searchbyphone.jsp").forward(request, response);
			}
			
			
		}
	}

}
