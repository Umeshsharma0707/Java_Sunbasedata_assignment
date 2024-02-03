package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDao;
import model.Customer;

/**
 * Servlet implementation class CustomerController
 */
@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerController() {
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
		
		
		String action = request.getParameter("action");
		
		// fetching user input values from form
		
		if(action.equalsIgnoreCase("add customer")) {
			Customer c = new Customer();
			
			c.setFirst_name(request.getParameter("firstname"));
			c.setLast_name(request.getParameter("lastname"));
			c.setStreet(request.getParameter("street"));
			c.setAddress(request.getParameter("address"));
			c.setCity(request.getParameter("city"));
			c.setState(request.getParameter("state"));
			c.setEmail(request.getParameter("email"));
			c.setPhone(Long.parseLong(request.getParameter("phone")));
			
			// calling method for insert customer
			
			CustomerDao.addCustomer(c);
			
			request.setAttribute("CustAddMsg", "Customer added successfully");
			request.getRequestDispatcher("admin-dashboard.jsp").forward(request, response);
			
		}
		// fetching data from edit customer form
		
		else if(action.equalsIgnoreCase("edit customer")) {
			Customer c = new Customer();
			
			c.setFirst_name(request.getParameter("firstname"));
			c.setLast_name(request.getParameter("lastname"));
			c.setStreet(request.getParameter("street"));
			c.setAddress(request.getParameter("address"));
			c.setCity(request.getParameter("city"));
			c.setState(request.getParameter("state"));
			c.setEmail(request.getParameter("email"));
			c.setPhone(Long.parseLong(request.getParameter("phone")));
			c.setId(Integer.parseInt(request.getParameter("id")));
			
			CustomerDao.updateCustomer(c);
			
			request.setAttribute("editMsg", "Customer details Updated Successfully");
			request.getRequestDispatcher("admin-dashboard.jsp").forward(request, response);
			
		}
	
		
		
	}

}
