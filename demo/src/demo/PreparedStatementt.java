package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementt {
	public static void main(String[] args) {
		String qry = "insert into student values(?,?,?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/jdbc_steps?user=root&&password=Kanha@123");
			PreparedStatement ps = con.prepareStatement(qry);
			
//			ps.setInt(1, 100);
//			ps.setString(2, "Kanha");
//			ps.setDouble(3, 56.5);
//			
//			ps.executeUpdate();
			
			
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("Insert Record :Sid,Name,Marks");

			for (int i = 1; i <= 3; i++) {
			    if (i == 1) {
			        System.out.print("Enter integer value(sid): ");
			        ps.setInt(i, scanner.nextInt());
			    } else if (i == 2) {
			        System.out.print("Enter string value(name): ");
			        ps.setString(i, scanner.next());
			    } else if (i == 3) {
			        System.out.print("Enter double value(marks): ");
			        ps.setDouble(i, scanner.nextDouble());
			    }
			}

			ps.executeUpdate();
			scanner.close();

			System.out.println("Record Inserted");

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
	}
}
