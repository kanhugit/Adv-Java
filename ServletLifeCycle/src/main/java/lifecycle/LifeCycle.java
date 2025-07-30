package lifecycle;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LifeCycle  extends GenericServlet{
	
	public LifeCycle() {
		System.out.println("Phase-1 excuted...");
	}
	
	public void Init() throws ServletException{
		System.out.println("Phase 2 excutedd..");
	}
	

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		 
		System.out.println("Phase 3 excuted ...");
		System.out.println(req.getParameter("nm"));
		System.out.println(req.getParameter("pass"));
		
	}
	public void destroy() {
		System.out.println("phase-4 executed");
		
	}

	
	
}
