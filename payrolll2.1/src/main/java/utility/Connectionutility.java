package utility;

import java.sql.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Connectionutility {
	
	public static Connection getconnection2() throws Exception
	{
		Connection con=null;
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		con=DriverManager.getConnection("jdbc:mysql://localhost/payroll2.0?user=root&password=root");
//		con=DriverManager.getConnection("jdbc:mysql://sql12.freesqldatabase.com:3306/sql12593639?user=sql12593639&password=ydixw234xF");
		return con;
		
	}
	
	 public static void check(HttpServletRequest request, HttpServletResponse response) throws Exception
	    {
	    	HttpSession session = request.getSession();
			
			response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
			if(session.getAttribute("Username")==null){

				 response.sendRedirect("../login/login.jsp");
			}
	    }
	
}
