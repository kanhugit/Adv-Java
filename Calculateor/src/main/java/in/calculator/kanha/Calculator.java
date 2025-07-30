package in.calculator.kanha;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Calculator extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int b = Integer.parseInt(req.getParameter("num1"));
        int c = Integer.parseInt(req.getParameter("num2"));

        // Perform addition
        int sum = b + c;

        // Send response
        PrintWriter pw = resp.getWriter();
        pw.println("<html><body bgcolor='pink'>");
        pw.println("<h1>Sum of Two numbers is: " + sum + "</h1>");
        pw.println("<h1>To get Square, click the button below:</h1>");
        pw.println("<form action='sq'>");
        pw.println("<input type='text' name='z' value='" + sum + "' hidden>");
        pw.println("<button type='submit'>Square</button>");
        pw.println("</form>");
        pw.println("</body></html>");
    }
}
