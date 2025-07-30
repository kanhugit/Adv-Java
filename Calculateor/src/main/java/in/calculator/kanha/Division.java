package in.calculator.kanha;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Division extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int d = (int) session.getAttribute("z");

        // Use double to avoid integer division issues
//        double div = (double) d / 2;
        	int div=d/0;

        // Send response
        PrintWriter pw = resp.getWriter();
        pw.println("<html><body bgcolor='pink'>");
        pw.println("<h1>The result after dividing by 2 is: " + div + "</h1>");
        pw.println("</body></html>");
    }
}
