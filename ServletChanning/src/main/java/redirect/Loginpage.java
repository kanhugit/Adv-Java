package redirect;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/log")
public class Loginpage extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("em");
		String pass=req.getParameter("ps");
		
		if(email.equals("kanha@gmail.com")&&pass.equals("Kanha@123")) {
			resp.sendRedirect("https://www.youtube.com/");
		} else {
			RequestDispatcher rd=req.getRequestDispatcher("Demo.html");
			rd.include(req, resp);
		}
		
	}
}
