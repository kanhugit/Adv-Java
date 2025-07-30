
//Establish a connection to a mysql database and print a success messageF

package jdbc_steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
	public static void main(String[] args) {
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nova_db?user=root&&password=Kanha@123");
			System.out.println("Connection established successfully");
			con.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
