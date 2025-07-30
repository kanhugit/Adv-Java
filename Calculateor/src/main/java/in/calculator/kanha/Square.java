package in.calculator.kanha;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Square extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Retrieve the parameter instead of an attribute
        int result = Integer.parseInt(req.getParameter("z"));
        int square = result * result;

        // Store squared result in session for Division servlet
        HttpSession session = req.getSession();
        session.setAttribute("z", square);

        // Send response
        PrintWriter pw = resp.getWriter();
        pw.println("<html><body>");
        pw.println("<h1>The Square of " + result + " is: " + square + "</h1>");
        pw.println("<h1>To divide by 2, click below:</h1>");
        pw.println("<form action='div'>");
        pw.println("<button type='submit'>Divide</button>");
        pw.println("</form>");
        pw.println("</body></html>");
    }
}
