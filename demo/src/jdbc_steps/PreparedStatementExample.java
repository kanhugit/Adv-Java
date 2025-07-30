package jdbc_steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


//using preparedStatement for parameterized Query
//using preparedStatement retrieve/fetch records based on Student ID
public class PreparedStatementExample {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_steps?user=root&&password=Kanha@123");
			PreparedStatement pstmt=con.prepareStatement("Select * from student where sid=?");
			pstmt.setInt(1, 101);
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getInt("sid")+"--"+rs.getString("name")+"--"+rs.getDouble("marks"));
			}
		
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}
}
