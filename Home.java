

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String str=request.getParameter("btn");
		response.setContentType("text/html");
		PrintWriter p=response.getWriter();
		switch(str) {
		
		case "LOGIN":
			             response.sendRedirect("LogIn.html");
			             break;
		case "SIGNUP":
			              response.sendRedirect("Reg.html");
			              break;
		case "update":
           			     response.sendRedirect("Ne.html");
                           break;
    
		}
	}

}
