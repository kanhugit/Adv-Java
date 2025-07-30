package channingservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp?user=root && password=Kanha@123");

			// Check if account exists
			String checkQuery = "SELECT * FROM user WHERE username=?";
			PreparedStatement checkStmt = con.prepareStatement(checkQuery);
			checkStmt.setString(1, username);
			ResultSet rs = checkStmt.executeQuery();

			if (rs.next()) {
				RequestDispatcher rd = request.getRequestDispatcher("student.html");
				out.println("<h3 style='color:red;'>Account already exists.</h3>");
				rd.include(request, response);
			} else {
				// Insert new user
				String insertQuery = "INSERT INTO user (id, username, password, email, contact) VALUES (?, ?, ?, ?, ?)";
				PreparedStatement ps = con.prepareStatement(insertQuery);
				ps.setInt(1, 3);
				ps.setString(2, username);
				ps.setString(3, password);
				ps.setString(4, email);
				ps.setString(5, contact);
				ps.executeUpdate();

				out.println("<h3 style='color:green;'>Account created successfully!</h3>");
				RequestDispatcher rd = request.getRequestDispatcher("Student.html");
				rd.include(request, response);
			}

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
