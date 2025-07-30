package jdbc_steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


//insert a new records into the "employees" table using preparedStatement
public class InsertRecordUsingPreparedStmt {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest?user=root&&password=Kanha@123");
			PreparedStatement pstmt=con.prepareStatement("insert into emp values(?,?,?,?)");
			
			pstmt.setInt(1, 11);
			pstmt.setString(2, "Kanha");
			pstmt.setDouble(3, 50000.0);
			pstmt.setInt(4, 22);
			pstmt.executeUpdate();
			System.out.println("Records inserted Succesfully");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}





























Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest", "root", "Kanha@123");

PreparedStatement ps = con.prepareStatement("DELETE FROM emp WHERE id=?");
ps.setInt(1, 11);
int rowsDeleted = ps.executeUpdate();

System.out.println("Deleted " + rowsDeleted + " row(s)");




















