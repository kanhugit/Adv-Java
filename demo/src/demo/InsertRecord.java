package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertRecord {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver class is loaded and Registered");
//		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","Kanha@123");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&&password=Kanha@123");
		System.out.println("Connection is established");
		Statement st=con.createStatement();
//		st.execute("insert into jdbc_steps.student.values(101,'Dimple',55.5)");
		st.executeUpdate("insert into jdbc_steps.student values(103,'Shella',79.5)");
		System.out.println("Recored inserted ");

	}
}
