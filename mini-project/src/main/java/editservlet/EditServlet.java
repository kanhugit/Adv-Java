package editservlet;

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

public class EditServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("userEmail") == null) {
            response.sendRedirect("login.html");
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

                out.println("<!DOCTYPE html>");
                out.println("<html lang='en'>");
                out.println("<head>");
                out.println("<meta charset='UTF-8'>");
                out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
                out.println("<title>Edit Profile</title>");
                out.println("<style>");
                out.println("body { font-family: Arial, sans-serif; text-align: center; padding: 20px; background: #f4f4f4; }");
                out.println(".container { background: white; width: 50%; margin: auto; padding: 20px; border-radius: 10px; box-shadow: 0px 0px 10px gray; }");
                out.println("input, button { padding: 10px; margin: 10px; width: 80%; }");
                out.println(".update-btn { background-color: #4CAF50; color: white; border: none; cursor: pointer; }");
                out.println("</style>");
                out.println("</head>");
                out.println("<body>");
                out.println("<div class='container'>");
                out.println("<h2>Edit Profile</h2>");
                out.println("<form action='UpdateServlet' method='post'>");
                out.println("<input type='hidden' name='email' value='" + email + "'>");
                out.println("<input type='text' name='firstName' value='" + firstName + "' required><br>");
                out.println("<input type='text' name='lastName' value='" + lastName + "' required><br>");
                out.println("<input type='text' name='contact' value='" + contact + "' required><br>");
                out.println("<button type='submit' class='update-btn'>Update</button>");
                out.println("</form>");
                out.println("</div>");
                out.println("</body>");
                out.println("</html>");
            } else {
                out.print("<h3>Error: User not found!</h3>");
            }
        } catch (Exception e) {
            out.print("<h3>Error: " + e.getMessage() + "</h3>");
        }
    }
}
