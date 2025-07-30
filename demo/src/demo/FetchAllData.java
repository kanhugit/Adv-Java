package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchAllData {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_steps?user=root&&password=Kanha@123");
			System.out.println("Connection is established");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from student");
			rs.next();
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3));
			rs.next();
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3));
			rs.next();
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3));
			rs.next();	
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
}
