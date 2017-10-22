

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter p=response.getWriter();
		String UserName=request.getParameter("un");
		String Mail=request.getParameter("email");
		String password=request.getParameter("psw");
		System.out.println(UserName+" "+Mail+" "+password);
		
		try{
	        
	        Class.forName("com.mysql.jdbc.Driver");
	        Connection  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/PavanDb","root","root");
            PreparedStatement ps=con.prepareStatement("insert into user values(?,?,?)");
            ps.setString(1,UserName);
	        ps.setString(2,Mail);
	        ps.setString(3,password);
	        int i=ps.executeUpdate();
	        if(i>0){
	        	p.println("You Successfully registered");
	           response.sendRedirect("Home1.html");
	               }
	        }catch(Exception se) {
	        	System.out.println(se);
	        	request.getRequestDispatcher("Reg.html").include(request, response);
	            p.println("User Name already exists");
	        }
	}

}
