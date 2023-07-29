package loginservlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utility.Connectionutility;
import utility.Encryption_Decryption;
import utility.OTPGENERATE_AND_MAIL;

/**
 * Servlet implementation class TwoFAServlet
 */
public class TwoFAServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TwoFAServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num=(int)(10000*Math.random());
		OTPGENERATE_AND_MAIL s=new OTPGENERATE_AND_MAIL();
		Encryption_Decryption ENC =new Encryption_Decryption();
		
		String StrUserName = request.getParameter("txtUser");
		String StrPwd = request.getParameter("txtPwd");
		int empid;
		String StrUserPosition=null,StrUser=null,DecodedPass = null;;
		
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
				empid=rs.getInt(1);
				StrUser=rs.getString(2);
				StrUserPosition=rs.getString(5);
				
				DecodedPass=ENC.decrypt(rs.getString(4),"Maddy");
				
				if(StrUserName.equals(rs.getString(3)) && StrPwd.equals(DecodedPass))
				{
					
					HttpSession session = request.getSession();
			        session.setAttribute("Username", StrUser);
			        session.setAttribute("Userid",empid);
			        session.setAttribute("UserPosition",StrUserPosition);
				
				if(rs2.next())
				{
					response.sendRedirect("../payrolll2.0/login/existingpin2facheck.jsp?aid="+StrUserName);
				}
				else
				{
					String StrQuery2="INSERT INTO otplogin (name,pin,ts) VALUES ('"+StrUserName+"',"+num+",CURRENT_TIMESTAMP);";
					stmt.executeUpdate(StrQuery2);
					s.sendEmail(num);
					response.sendRedirect("../payrolll2.0/login/new2FACHECK.jsp?aid="+StrUserName); //url rewriting
				}
				
			   }
				else
				{
					response.sendRedirect("../payrolll2.0/login/login.jsp");
				}
			}
			else
			{
				response.sendRedirect("../payrolll2.0/login/login.jsp");
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
