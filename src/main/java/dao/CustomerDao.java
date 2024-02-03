package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.DBConnection;
import model.Customer;

public class CustomerDao {
	
	// method for add customer in database
		public static void addCustomer(Customer c) {
				try {
					Connection conn = DBConnection.createConnection();
					String sql = "insert into customers (first_name,last_name,street,address,city,state,email,phone) values (?,?,?,?,?,?,?,?) ";       
					PreparedStatement pst = conn.prepareStatement(sql);
					
					pst.setString(1, c.getFirst_name());
					pst.setString(2, c.getLast_name());
					pst.setString(3, c.getStreet());
					pst.setString(4, c.getAddress());
					pst.setString(5, c.getCity());
					pst.setString(6, c.getState());
					pst.setString(7, c.getEmail());
					pst.setLong(8, c.getPhone());
					
					pst.executeUpdate(); // inserts the data in customers table
					
					System.out.println("customer added successfully");
					
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		
		// fetch all customers list
		
		public static List<Customer> getAllCustomers(){
			List<Customer> list = new ArrayList<Customer>();
			
			try {
				Connection conn = DBConnection.createConnection();
				String Sql = "select * from customers";
				PreparedStatement pst = conn.prepareStatement(Sql);
				
				// executing query and getting data into customer object
				
				ResultSet rs = pst.executeQuery();
				
				while(rs.next()) {
					Customer c = new Customer();
					
					c.setId(rs.getInt("id"));
					c.setFirst_name(rs.getString("first_name"));
					c.setLast_name(rs.getString("last_name"));
					c.setStreet(rs.getString("street"));
					c.setAddress(rs.getString("address"));
					c.setCity(rs.getString("city"));
					c.setState(rs.getString("state"));
					c.setEmail(rs.getString("email"));
					c.setPhone(rs.getLong("phone"));
					
					list.add(c);
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return list;
		}
		
		
		// get customer by id method
		
		public static Customer getCustomerById(int id) {
			Customer c1 = null;
			
			try {
				Connection conn = DBConnection.createConnection();
				String sql = "select * from customers where id = ?";
				PreparedStatement pst = conn.prepareStatement(sql);
				
				pst.setInt(1, id);
				
				// executing query
				
				 ResultSet rs =  pst.executeQuery();
				
				 if(rs.next()) {
					 c1 = new Customer();
					 c1.setId(rs.getInt("id"));
					 c1.setFirst_name(rs.getString("first_name"));
					 c1.setLast_name(rs.getString("last_name"));
					 c1.setStreet(rs.getString("street"));
					 c1.setAddress(rs.getString("address"));
					 c1.setState(rs.getString("state"));
					 c1.setCity(rs.getString("city"));
					 c1.setEmail(rs.getString("email"));
					 c1.setPhone(rs.getLong("phone"));
					 
				 }
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return c1;
		}
		
		// for edit customer
		
		public static void updateCustomer(Customer c) {
			try {
				Connection conn = DBConnection.createConnection();
				String sql = "update customers set first_name=?,last_name=?,street=?,address=?,city=?,state=?,email=?,phone=? where id =?";
				PreparedStatement pst = conn.prepareStatement(sql);
				
				pst.setString(1, c.getFirst_name());
				pst.setString(2, c.getLast_name());
				pst.setString(3, c.getStreet());
				pst.setString(4, c.getAddress());
				pst.setString(5, c.getCity());
				pst.setString(6, c.getState());
				pst.setString(7, c.getEmail());
				pst.setLong(8, c.getPhone());
				pst.setInt(9, c.getId());
				
				// updating customer by id
				
				pst.executeUpdate();
				
				System.out.println("data updated successfully");
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// for delete customer by id
		
		public static void deleteCustomer(int id) {
			
			try {
				Connection conn = DBConnection.createConnection();
				String sql = "delete from customers where id = ?";
				PreparedStatement pst = conn.prepareStatement(sql);
				
				pst.setInt(1, id);
				
				pst.executeUpdate();
				System.out.println("customer deleted successfully");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
}








