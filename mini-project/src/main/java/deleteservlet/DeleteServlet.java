package deleteservlet;


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

public class DeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("userEmail");

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM users WHERE email=?");
            ps.setString(1, email);

            int i = ps.executeUpdate();
            if (i > 0) {
                session.invalidate();
                out.print("<h3>Account Deleted Successfully! <a href='index.html'>Back to Home</a></h3>");
            } else {
                out.print("<h3>Error: Deletion Failed!</h3>");
            }

        } catch (Exception e) {
            out.print("<h3>Error: " + e.getMessage() + "</h3>");
        }
    }
}

