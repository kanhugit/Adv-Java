package demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class CreateTable {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver class is loaded and Registered");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","Kanha@123");
			System.out.println("Connection is established");
			Statement stmt=con.createStatement();
			System.out.println("Platform Created ");
//			stmt.execute("create table jdbc_steps.student(sid int,name varchar(25),marks double)");
			System.out.println("Table Created");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
