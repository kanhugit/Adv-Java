package demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class CreateTable2 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver class is loaded and Registered");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","Kanha@123");
			System.out.println("Connection is established");
			Statement stmt=con.createStatement();
			System.out.println("Platform Created ");
			stmt.execute("create table jsp.Emp(Eid int,Ename varchar(25),Esal double,Edeptno int)");
			System.out.println("Emp Table Created");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
