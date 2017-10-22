

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


@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email=request.getParameter("ume");
		String pass=request.getParameter("ps");
		PrintWriter p=response.getWriter();
	    try{
	          Class.forName("com.mysql.jdbc.Driver");
	          Connection  con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","root");
              PreparedStatement ps=con.prepareStatement("select * from PavanDb.user where Mail=? and password=?");
              ps.setString(1,email);
              ps.setString(2, pass);
	          ResultSet re=ps.executeQuery();
              if(re.next()) 
              {
            	  response.sendRedirect("Registration.html");
              }
              
	          
	        }catch(Exception e) {
	            e.printStackTrace();
	            request.getRequestDispatcher("LogIn.html").include(request, response);
	            p.println("User Name OR pASSWORD iNVALID");
	        }
		
	}

}
