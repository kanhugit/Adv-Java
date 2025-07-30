package dashboard;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbconnection.DBConnection;

public class DashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("userEmail") == null) {
            out.print("<h3>You are not logged in! <a href='login.html'>Login Here</a></h3>");
            return;
        }

        String email = (String) session.getAttribute("userEmail");

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT first_name, last_name, contact FROM users WHERE email=?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String contact = rs.getString("contact");

                out.print("<h2>Welcome, " + firstName + " " + lastName + "</h2>");
                out.print("<p>Email: " + email + "</p>");
                out.print("<p>Contact: " + contact + "</p>");

                out.print("<button onclick=\"window.location.href='edit.html'\">Edit</button>");
                out.print("<button onclick=\"confirmDelete()\">Delete</button>");
                out.print("<br><br><a href='logout'>Logout</a>");

                out.print("<script>");
                out.print("function confirmDelete() { if (confirm('Are you sure you want to delete your account?')) { window.location.href='DeleteServlet'; } }");
                out.print("</script>");
            } else {
                out.print("<h3>Error: User not found!</h3>");
            }

        } catch (Exception e) {
            out.print("<h3>Error: " + e.getMessage() + "</h3>");
        }
    }
}

