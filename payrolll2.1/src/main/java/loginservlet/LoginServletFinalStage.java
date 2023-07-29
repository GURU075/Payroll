package loginservlet;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

import utility.Connectionutility;

/**
 * Servlet implementation class loginservlet2
 */
public class LoginServletFinalStage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServletFinalStage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String StrUserName = request.getParameter("txtUser");
		String StrPwd = request.getParameter("txtPwd");
		String Pin = request.getParameter("Pin");
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String StrQuery="select * from loginid where USERNAME='"+StrUserName+"' and PASSWORD='"+StrPwd+"'";
		String StrQuery1="select * from otplogin where name='"+StrUserName+"' and pin="+Pin;
		//joins
		Connection con=null;
		try
		{
			con=Connectionutility.getconnection2();
			Statement stmt=con.createStatement();
			Statement stmt1=con.createStatement();
			ResultSet rs1=stmt1.executeQuery(StrQuery1);
			ResultSet rs=stmt.executeQuery(StrQuery);
			
			
			if(rs.next() && rs1.next())
			{
				if(rs.getString(5).equalsIgnoreCase("admin"))
				{
					response.sendRedirect("../payrolll2.0/panel1/AdminPanel.jsp");
				}
				else if(rs.getString(5).equalsIgnoreCase("HR"))
				{
					response.sendRedirect("../payrolll2.0/panel1/HRPanel.jsp");
				}
				else if(rs.getString(5).equalsIgnoreCase("EMP"))
				{
					response.sendRedirect("../payrolll2.0/panel1/EmployeePanel.jsp");
				}
				else
				{
					out.print("Your Are Not In System Contact Admin");
				}				
			}
			
			
			else
			{
				response.sendRedirect("../payrolll2.0/login/incorrectotp.jsp?aid="+StrUserName);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
