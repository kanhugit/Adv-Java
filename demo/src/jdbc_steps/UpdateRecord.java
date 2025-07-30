package jdbc_steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//WAP to update the salary of an Employee using PreparedStatement
public class UpdateRecord {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_steps?user=root&&password=Kanha@123");
			PreparedStatement ps=con.prepareStatement("UPDATE employee  SET esal=? WHERE eid=?");
			   ps.setDouble(1, 80000); // New salary
	            ps.setInt(2, 11); // Update salary for Eid = 11
			ps.executeUpdate();
			System.out.println("data updated sucessfully ");
			 ps.close();
	         con.close();
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}
}
