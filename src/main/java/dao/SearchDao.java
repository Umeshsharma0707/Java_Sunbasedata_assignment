package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.DBConnection;
import model.Customer;

public class SearchDao {
	
	// method for search customer by firstname
	
	public static List<Customer> getByFirstName(String firstName) { 
		List<Customer> list = new ArrayList<Customer>();
		
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select * from customers where first_name=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			
			pst.setString(1, firstName);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				Customer c1 = new Customer();
				
				c1.setId(rs.getInt("id"));
				c1.setFirst_name(rs.getString("first_name"));
				c1.setLast_name(rs.getString("last_name"));
				c1.setStreet(rs.getString("street"));
				c1.setAddress(rs.getString("address"));
				c1.setCity(rs.getString("city"));
				c1.setState(rs.getString("state"));
				c1.setEmail(rs.getString("email"));
				c1.setPhone(rs.getLong("phone"));
				
				list.add(c1);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	// search customer by city
	
	public static List<Customer> getByCity(String city){
		
	 List<Customer> list = new ArrayList<Customer>();
		
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select * from customers where city=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			
			pst.setString(1, city);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				Customer c1 = new Customer();
				
				c1.setId(rs.getInt("id"));
				c1.setFirst_name(rs.getString("first_name"));
				c1.setLast_name(rs.getString("last_name"));
				c1.setStreet(rs.getString("street"));
				c1.setAddress(rs.getString("address"));
				c1.setCity(rs.getString("city"));
				c1.setState(rs.getString("state"));
				c1.setEmail(rs.getString("email"));
				c1.setPhone(rs.getLong("phone"));
				
				list.add(c1);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	// search customer by email
	
		public static List<Customer> getByEmail(String email){
			
		 List<Customer> list = new ArrayList<Customer>();
			
			try {
				Connection conn = DBConnection.createConnection();
				String sql = "select * from customers where email=?";
				PreparedStatement pst = conn.prepareStatement(sql);
				
				pst.setString(1, email);
				
				ResultSet rs = pst.executeQuery();
				
				while(rs.next()) {
					Customer c1 = new Customer();
					
					c1.setId(rs.getInt("id"));
					c1.setFirst_name(rs.getString("first_name"));
					c1.setLast_name(rs.getString("last_name"));
					c1.setStreet(rs.getString("street"));
					c1.setAddress(rs.getString("address"));
					c1.setCity(rs.getString("city"));
					c1.setState(rs.getString("state"));
					c1.setEmail(rs.getString("email"));
					c1.setPhone(rs.getLong("phone"));
					
					list.add(c1);
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return list;
		}
		
		// search customer by phone
		
		public static List<Customer> getByPhone(String phone){
			
		 List<Customer> list = new ArrayList<Customer>();
			
			try {
				Connection conn = DBConnection.createConnection();
				String sql = "select * from customers where phone=?";
				PreparedStatement pst = conn.prepareStatement(sql);
				
				pst.setString(1, phone);
				
				ResultSet rs = pst.executeQuery();
				
				while(rs.next()) {
					Customer c1 = new Customer();
					
					c1.setId(rs.getInt("id"));
					c1.setFirst_name(rs.getString("first_name"));
					c1.setLast_name(rs.getString("last_name"));
					c1.setStreet(rs.getString("street"));
					c1.setAddress(rs.getString("address"));
					c1.setCity(rs.getString("city"));
					c1.setState(rs.getString("state"));
					c1.setEmail(rs.getString("email"));
					c1.setPhone(rs.getLong("phone"));
					
					list.add(c1);
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return list;
		}
}




