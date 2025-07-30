package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InserData {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver class is loaded and Registered");
//		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","Kanha@123");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&&password=Kanha@123");
		System.out.println("Connection is established");
		Statement st=con.createStatement();
//		st.execute("insert into jdbc_steps.student.values(101,'Dimple',55.5)");
		st.executeUpdate("insert into jdbc_steps.emp values(10,'kanha',12000,1)");
		st.executeUpdate("insert into jdbc_steps.emp values(11,'Balia',10000,2)");
		st.executeUpdate("insert into jdbc_steps.emp values(12,'jitu',2000,3)");
		st.executeUpdate("insert into jdbc_steps.emp values(13,'puja',5000,1)");
		st.executeUpdate("insert into jdbc_steps.emp values(14,'kanha',1000,2)");
		st.executeUpdate("insert into jdbc_steps.emp values(15,'kanha',1000,3)");
		st.executeUpdate("insert into jdbc_steps.emp values(16,'kanha',5000,1)");
		st.executeUpdate("insert into jdbc_steps.emp values(17,'muna',12000,1)");


		System.out.println("Recored inserted ");

	}
}
