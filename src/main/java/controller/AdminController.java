package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDao;
import model.Admin;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// action is the name of button in the form 
		// with the help of getParameter we get it in the servlet
		
		
		String action = request.getParameter("action");
		
		// if action button's value is login then
		
		if(action.equalsIgnoreCase("login")) {
			// creating an admin constructor and object
			Admin a = new Admin(); // by importing  model class admin
			
			a.setUsername(request.getParameter("email")); //get value from the login form username
			a.setPassword(request.getParameter("password"));
			
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			// printing user inputs in console
			System.out.println(a.getUsername());
			System.out.println(a.getPassword());
			
			// checking email in database is present or not
			
			boolean flag = AdminDao.checkEmail(email);
			
			if (flag == true) {
				boolean flag1 = AdminDao.checkPassword(password);
				if(flag1 == true) {
					Admin a1 = AdminDao.adminLogin(a);
					System.out.println(a1);
					
					if(a1!=null) {
						HttpSession session = request.getSession();
						session.setAttribute("data", a1);
						request.getRequestDispatcher("admin-dashboard.jsp").forward(request, response);
					}else {
						request.setAttribute("wrng", "some problems in login");
						request.getRequestDispatcher("index.jsp").forward(request, response);
					}
					
				}else {
					request.setAttribute("wrngPass", "oops! you entered wrong Password");
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
			}else {
				request.setAttribute("wrngEmail", "oops! you entered wrong email");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			
			
			
		}
		
	}

}














