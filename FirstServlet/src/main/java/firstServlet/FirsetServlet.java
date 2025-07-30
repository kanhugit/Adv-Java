package firstServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirsetServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fname=req.getParameter("fn");
		String lname=req.getParameter("ln");
		int age=Integer.parseInt(req.getParameter("ag"));
		String email=req.getParameter("em");
		String pwd=req.getParameter("ps");
		
//		System.out.println("FirstName:"+fname+"LastName:"+lname+"age"+age+"email:"+email+"password"+pwd);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp?user=root && password=Kanha@123");
			PreparedStatement pstmt=con.prepareStatement("insert into emp values(?,?,?,?,?)");
			pstmt.setString(1, fname);
			pstmt.setString(2, lname);
			pstmt.setInt(3, age);
			pstmt.setString(4, email);
			pstmt.setString(5, pwd);

			pstmt.executeUpdate();
			System.out.println("Records inserted Succesfully");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter pw=resp.getWriter();
		pw.println("<html><body bgcolor='yellow' textalign='Center'>");
		pw.println("<h1>Thank You</h1>");
		pw.println("<body></html>");
		
	}

}
