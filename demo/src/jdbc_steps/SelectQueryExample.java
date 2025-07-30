package jdbc_steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//WAP to execute a select query on a  table
public class SelectQueryExample {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp?user=root&&password=Kanha@123");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from fb");
			
			while(rs.next()) {
//				System.out.println(rs.getInt("userid")+"-"+rs.getString("password"));
				System.out.println(rs.getInt(1)+"-"+rs.getString(2));
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}
}
