package updateservlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbconnection.DBConnection;

public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("userEmail");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String contact = request.getParameter("contact");

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("UPDATE users SET first_name=?, last_name=?, contact=? WHERE email=?");

            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, contact);
            ps.setString(4, email);

            int i = ps.executeUpdate();
            if (i > 0) {
                out.print("<h3>Profile Updated Successfully! <a href='dashboard.html'>Back to Dashboard</a></h3>");
            } else {
                out.print("<h3>Error: Update Failed!</h3>");
            }

        } catch (Exception e) {
            out.print("<h3>Error: " + e.getMessage() + "</h3>");
        }
    }
}

