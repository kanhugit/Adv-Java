package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchData {
	public static void main(String[] args) {
		String qry = "select * from student where sid=?";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_steps?user=root&&password=Kanha@123");
			PreparedStatement ps = con.prepareStatement(qry);
			ps.setInt(1, 100);
			ResultSet rs=ps.executeQuery();
			rs.next();
//			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3));
			System.out.println(rs.getInt(3));


			System.out.println("Fetched data succesfully");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
}
