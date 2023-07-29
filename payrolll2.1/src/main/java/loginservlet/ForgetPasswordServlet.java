package loginservlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utility.Connectionutility;
import utility.OTPGENERATE_AND_MAIL;

/**
 * Servlet implementation class ForgetPasswordServlet
 */
public class ForgetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgetPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num=(int)(10000*Math.random());
		OTPGENERATE_AND_MAIL s=new OTPGENERATE_AND_MAIL();
		
		String StrUserName = request.getParameter("txtUser");
		String StrUser=null;
		
		Connection con=null;
		try
		{
			String StrQuery3="select * from loginid where USERNAME='"+StrUserName+"'";
			con=Connectionutility.getconnection2();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(StrQuery3);
			
			String StrQuery1="delete from otplogin WHERE ts <= NOW() - INTERVAL 5 minute;";
			Statement stmt3=con.createStatement();
			stmt3.executeUpdate(StrQuery1);
			
			String StrQuery4="select * from otplogin where name='"+StrUserName+"'";
			Statement stmt2=con.createStatement();
			ResultSet rs2=stmt2.executeQuery(StrQuery4);
			
			if(rs.next())
			{
				StrUser=rs.getString(2);
				if(StrUserName.equals(rs.getString(3)))
				{
				if(rs2.next())
				{
					response.sendRedirect("../payrolll2.0/ForgetPassword/ExistingPin.jsp?aid="+StrUserName);
				}
				else
				{
					String StrQuery2="INSERT INTO otplogin (name,pin,ts) VALUES ('"+StrUserName+"',"+num+",CURRENT_TIMESTAMP);";
					stmt.executeUpdate(StrQuery2);
					s.sendEmail(num);
					response.sendRedirect("../payrolll2.0/ForgetPassword/OTPVerification.jsp?aid="+StrUserName); //url rewriting
				}
				
			   }
				else
				{
					response.sendRedirect("../payrolll2.0/ForgetPassword/ForgetPassword.html");
				}
			}
			else
			{
				response.sendRedirect("../payrolll2.0/ForgetPassword/ForgetPassword.html");
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
