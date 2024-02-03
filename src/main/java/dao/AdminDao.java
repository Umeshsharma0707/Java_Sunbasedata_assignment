package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.DBConnection;
import model.Admin;

public class AdminDao {
		
	// method for check admin entering email for login is correct or not
	
	public static boolean checkEmail(String email) {
		boolean flag = false;
		
		try {
			Connection conn = DBConnection.createConnection();
			
			// mysql query to check entered email is present in database or not
			String sql = "select * from admin where username = ?"; // username is the users email id
			PreparedStatement pst = conn.prepareStatement(sql);
			
			pst.setString(1, email);
			
			ResultSet rs = pst.executeQuery(); // it executes the sql query
			
			
			
			if(rs.next()) {  // if data is found in resultset then flag is true
				flag = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return flag;
	}
	
	// check password
	
	
	public static boolean checkPassword(String Password) {
		boolean flag = false;
		
		
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select * from admin where password = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			
			pst.setString(1, Password);
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				flag = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	// admin login
	
	public static Admin adminLogin(Admin a) {
		Admin a1 = null;
		
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select * from admin where username = ? and password = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			
			pst.setString(1, a.getUsername());
			pst.setString(2, a.getPassword());
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				a1 = new Admin();
				
				a1.setId(rs.getInt("id"));
				a1.setPassword(rs.getString("password"));
				a1.setUsername(rs.getString("username"));
			}
			System.out.println("id : "+ a1.getId());
			System.out.println("email : "+ a1.getUsername());
			System.out.println("password : "+ a1.getPassword());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return a1;
				
	}
	
}





