package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VerifyAuthentication {
	public static void main(String[] args) {
		int userid=12;
		String password="Swati@123";
//		String qry="select * from fb where userid=? AND password=?";
        String qry = "SELECT * FROM fb WHERE userid = '" + userid + "' AND password = '" + password + "'";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp?user=root&&password=Kanha@123");
			Statement stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(qry);
			 if (rs.next()) {
	                System.out.println("Login successful!");
	            } else {
	                System.out.println("Invalid username or password.");
	            }

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
