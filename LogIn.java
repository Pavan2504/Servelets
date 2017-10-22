import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LogIn")
public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email=request.getParameter("uname");
		String pass=request.getParameter("psw");
		response.setContentType("text/html");
		PrintWriter p=response.getWriter();
		//boolean st;

		boolean status=false;  
	    try{
	          Class.forName("com.mysql.jdbc.Driver");
	          Connection  con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","root");
              PreparedStatement ps=con.prepareStatement("select * from PavanDb.user where UserName=? and password=?");
              ps.setString(1,email);
              ps.setString(2,pass);
              ResultSet r=ps.executeQuery();
              System.out.println(r.next());
              status=r.next();
	          if(status!=true){
	        	  
	        	  response.sendRedirect("New.html");
	        	  p.println("You Successfully login");
		          
	        	  
	          }
	          
	          else{
	        	  request.getRequestDispatcher("LogIn.html").include(request, response);
		            p.println("User Name OR PASSWORD iNVALID");
	          }
	          
	          
	        }catch(Exception e) {
	            System.out.println(e);
	        }
		
		
	}

}
