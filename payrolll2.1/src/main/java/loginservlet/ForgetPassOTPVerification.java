package loginservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utility.Connectionutility;

/**
 * Servlet implementation class ForgetPassOTPVerification
 */
public class ForgetPassOTPVerification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgetPassOTPVerification() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String StrUserName = request.getParameter("txtUser");
		String Pin = request.getParameter("Pin");
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String StrQuery1="select * from otplogin where name='"+StrUserName+"' and pin="+Pin;
		//joins
		Connection con=null;
		try
		{
			con=Connectionutility.getconnection2();
			Statement stmt1=con.createStatement();
			ResultSet rs1=stmt1.executeQuery(StrQuery1);
			
			
			if(rs1.next())
			{
				response.sendRedirect("../payrolll2.0/ForgetPassword/NewPassword.jsp?aid="+StrUserName);		
			}
			
			
			else
			{
				response.sendRedirect("../payrolll2.0/ForgetPassword/IncorrectOTP.jsp?aid="+StrUserName);
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
